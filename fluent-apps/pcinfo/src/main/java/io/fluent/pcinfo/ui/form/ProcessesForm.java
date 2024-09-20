package io.fluent.pcinfo.ui.form;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import io.fluent.pcinfo.App;
import io.fluent.pcinfo.ui.UiConsts;
import io.fluent.pcinfo.util.SystemUtil;
import lombok.Getter;
import org.apache.commons.imaging.formats.icns.IcnsImageParser;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import xmlwise.Plist;

import javax.swing.Timer;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.*;

/**
 * ProcessesForm
 *
 * @author <a href="https://github.com/rememberber">RememBerBer</a>
 * @since 2021/11/15.
 */
@Getter
public class ProcessesForm {
	private static final String[] COLUMNS = {"Icon", "PID", "PPID", "Threads", "% CPU", "Cumulative", "VSZ", "RSS", "% Memory",
		"Process Name"};
	private static final double[] COLUMN_WIDTH_PERCENT = {0.01, 0.07, 0.07, 0.07, 0.07, 0.09, 0.1, 0.1, 0.08, 0.35};

	private final static Map<Integer, OSProcess> priorSnapshotMap = new HashMap<>();
	private final static HashMap<String, Icon> iconCacheMap = new HashMap<>();
	private static final Log logger = LogFactory.get();

	private static ProcessesForm processesForm;
	private JPanel mainPanel;
	private JTable processTable;
	private JRadioButton cpuButton;
	private JRadioButton cumulativeCpuButton;
	private JRadioButton memButton;
	private JRadioButton perProc;
	private JRadioButton perSystem;

	public static ProcessesForm getInstance() {
		if (processesForm == null) {
			processesForm = new ProcessesForm();
		}
		return processesForm;
	}

	public static void init() {
		processesForm = getInstance();

		initUi();
		initInfo();
	}

	private static void initUi() {
		resetCpuPercentButtonGroup();
		resetSortByButtonGroup();

		processesForm = getInstance();
		if (SystemInfo.getCurrentPlatform().equals(PlatformEnum.WINDOWS)) {
			processesForm.perSystem.setSelected(true);
		} else {
			processesForm.perProc.setSelected(true);
		}
		processesForm.cpuButton.setSelected(true);

		processesForm.perProc.addActionListener(e -> {
			resetCpuPercentButtonGroup();
			processesForm.perProc.setSelected(true);
		});
		processesForm.perSystem.addActionListener(e -> {
			resetCpuPercentButtonGroup();
			processesForm.perSystem.setSelected(true);
		});

		processesForm.cpuButton.addActionListener(e -> {
			resetSortByButtonGroup();
			processesForm.cpuButton.setSelected(true);
		});
		processesForm.cumulativeCpuButton.addActionListener(e -> {
			resetSortByButtonGroup();
			processesForm.cumulativeCpuButton.setSelected(true);
		});
		processesForm.memButton.addActionListener(e -> {
			resetSortByButtonGroup();
			processesForm.memButton.setSelected(true);
		});
	}

	/**
	 * Codes are copied from oshi and have some modifications.
	 */
	private static void initInfo() {
		OperatingSystem os = App.si.getOperatingSystem();
		TableModel model = new DefaultTableModel(parseProcesses(os.getProcesses(null, null, 0), App.si), COLUMNS) {
			@Override
			public Class<?> getColumnClass(int column) {
				if (column == 0) {

					return ImageIcon.class;
				}
				return Object.class;
			}
		};
		JTable procTable = getInstance().getProcessTable();
		procTable.setModel(model);
		resizeColumns(procTable.getColumnModel());
		procTable.getColumnModel().getColumn(0).setMaxWidth(32);
		procTable.getColumnModel().getColumn(0).setMinWidth(32);
		procTable.setShowGrid(true);

		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) procTable.getTableHeader()
			.getDefaultRenderer();
		// The name of header column turn to left
		hr.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);

		Timer timer = new Timer(UiConsts.REFRESH_SLOW, e -> {
			DefaultTableModel tableModel = (DefaultTableModel) procTable.getModel();
			Object[][] newData = parseProcesses(os.getProcesses(null, null, 0), App.si);
			int rowCount = tableModel.getRowCount();
			for (int row = 0; row < newData.length; row++) {
				if (row < rowCount) {
					// Overwrite row
					for (int col = 0; col < newData[row].length; col++) {
						tableModel.setValueAt(newData[row][col], row, col);
					}
				} else {
					// Add row
					tableModel.addRow(newData[row]);
				}
			}
			// Delete any extra rows
			for (int row = rowCount - 1; row >= newData.length; row--) {
				tableModel.removeRow(row);
			}
		});
		timer.start();
	}

	/**
	 * Codes are copied from oshi and have some modifications.
	 *
	 * @param list
	 * @param si
	 * @return
	 */
	private static Object[][] parseProcesses(List<OSProcess> list, SystemInfo si) {
		processesForm = getInstance();
		long totalMem = si.getHardware().getMemory().getTotal();
		int cpuCount = si.getHardware().getProcessor().getLogicalProcessorCount();
		// Build a map with a value for each process to control the sort
		Map<OSProcess, Double> processSortValueMap = new HashMap<>();
		for (OSProcess p : list) {
			int pid = p.getProcessID();
			// Ignore the Idle process on Windows
			if (pid > 0 || !SystemInfo.getCurrentPlatform().equals(PlatformEnum.WINDOWS)) {
				// Set up for appropriate sort
				if (processesForm.cpuButton.isSelected()) {
					processSortValueMap.put(p, p.getProcessCpuLoadBetweenTicks(priorSnapshotMap.get(pid)));
				} else if (processesForm.cumulativeCpuButton.isSelected()) {
					processSortValueMap.put(p, p.getProcessCpuLoadCumulative());
				} else {
					processSortValueMap.put(p, (double) p.getResidentSetSize());
				}
			}
		}
		// Now sort the list by the values
		List<Map.Entry<OSProcess, Double>> procList = new ArrayList<>(processSortValueMap.entrySet());
		procList.sort(Map.Entry.comparingByValue());
		// Insert into array in reverse order (lowest sort value last)
		int i = procList.size();
		Object[][] procArr = new Object[i][COLUMNS.length];
		// These are in descending CPU order
		for (Map.Entry<OSProcess, Double> e : procList) {
			OSProcess p = e.getKey();
			// Matches order of COLUMNS field
			i--;
			int pid = p.getProcessID();
			procArr[i][0] = getProcessIcon(p.getPath());
			procArr[i][1] = pid;
			procArr[i][2] = p.getParentProcessID();
			procArr[i][3] = p.getThreadCount();
			if (processesForm.perProc.isSelected()) {
				procArr[i][4] = String.format("%.1f",
					100d * p.getProcessCpuLoadBetweenTicks(priorSnapshotMap.get(pid)) / cpuCount);
				procArr[i][5] = String.format("%.1f", 100d * p.getProcessCpuLoadCumulative() / cpuCount);
			} else {
				procArr[i][4] = String.format("%.1f",
					100d * p.getProcessCpuLoadBetweenTicks(priorSnapshotMap.get(pid)));
				procArr[i][5] = String.format("%.1f", 100d * p.getProcessCpuLoadCumulative());
			}
			procArr[i][6] = FormatUtil.formatBytes(p.getVirtualSize());
			procArr[i][7] = FormatUtil.formatBytes(p.getResidentSetSize());
			procArr[i][8] = String.format("%.1f", 100d * p.getResidentSetSize() / totalMem);
			procArr[i][9] = p.getName();
		}
		// Re-populate snapshot map
		priorSnapshotMap.clear();
		for (OSProcess p : list) {
			priorSnapshotMap.put(p.getProcessID(), p);
		}
		return procArr;
	}

	/**
	 * Retrieves the executable's associated icon if available, or returns null.
	 *
	 * @param fullProcessPathName The full path of the executable process.
	 * @return The associated icon, or null if not found.
	 */
	private static Icon getProcessIcon(String fullProcessPathName) {
		if (iconCacheMap.containsKey(fullProcessPathName)) {
			return iconCacheMap.get(fullProcessPathName);
		}

		File file = new File(fullProcessPathName);
		if (!file.exists()) {
			// Alternatively, provide a default icon or return nul
			return UIManager.getIcon("FileView.fileIcon");
		}

		try {
			if (SystemUtil.isWindowsOs()) {
				Icon icon = FileSystemView.getFileSystemView().getSystemIcon(file);
				iconCacheMap.put(fullProcessPathName, icon);
				return icon;
			}

      if (SystemUtil.isLinuxOs()) {
        // investigate why getPath or getCommandLine is "" on kali
      }

			// macOS-specific icon retrieval
			// maybe find a simpler solution
			// Todo : fix various icons like VLC ...
			if (SystemUtil.isMacOs() && fullProcessPathName.contains("MacOS")) {
				String iconPathSplit = fullProcessPathName.split("MacOS")[0];
				String plistFilePath = iconPathSplit + "Info.plist";

				File pListFile = getFileWithSpaceUri(plistFilePath);
				if (pListFile.exists()) {
					Map<String, Object> properties = Plist.load(plistFilePath);
					String cFBundleIconFile = (String) properties.get("CFBundleIconFile");
					String iconFilePath = iconPathSplit + "Resources/" + cFBundleIconFile;

					// Ensure file path ends with ".icns"
					if (!iconFilePath.endsWith(".icns")) {
						iconFilePath += ".icns";
					}

					File iconFile = getFileWithSpaceUri(iconFilePath);
					if (iconFile.canRead()) {
						List<BufferedImage> iconImages = new IcnsImageParser().getAllBufferedImages(iconFile);
						Optional<BufferedImage> resultImage = iconImages
							.stream().parallel()
							.filter(num -> num.getRaster().getHeight() == 32).findAny();

						if (resultImage.isPresent()) {
							BufferedImage bufferedImageR = resizeImage(resultImage.get(), 26, 26);
							Icon icon = new ImageIcon(bufferedImageR);
							iconCacheMap.put(fullProcessPathName, icon);
							return icon;
						}

					}
				}
			}
		} catch (Exception e) {
		}
		return UIManager.getIcon("FileView.fileIcon");
	}

	/**
	 *  Workaround to open folders files with spaces
	 *  @param filePath
	 *  @return file
	 */
	private static File getFileWithSpaceUri(String filePath) throws URISyntaxException {
		URI outputURI = new URI(("file:///" + filePath.replaceAll(" ", "%20")));
		File outputFile = new File(outputURI);
		return outputFile;
	}

	/**
	 * ResizeImage BufferedImage to given targetWidth targetHeight preserve transparency
	 *
	 * @param originalImage
	 * @param targetWidth
	 * @param targetHeight
	 * @return resizeImage
	 */
	public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
		BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics2D graphics2D = resizedImage.createGraphics();
		graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
		graphics2D.dispose();
		return resizedImage;
	}


	/**
     * Codes are copied from oshi and have some modifications.
     *
     * @param tableColumnModel
     */
    private static void resizeColumns(TableColumnModel tableColumnModel) {
        TableColumn column;
        int tW = tableColumnModel.getTotalColumnWidth();
        int cantCols = tableColumnModel.getColumnCount();
        for (int i = 0; i < cantCols; i++) {
            column = tableColumnModel.getColumn(i);
            int pWidth = (int) Math.round(COLUMN_WIDTH_PERCENT[i] * tW);
            column.setPreferredWidth(pWidth);
        }
    }

    private static void resetSortByButtonGroup() {
        processesForm = getInstance();

        processesForm.cpuButton.setSelected(false);
        processesForm.cumulativeCpuButton.setSelected(false);
        processesForm.memButton.setSelected(false);
    }

    private static void resetCpuPercentButtonGroup() {
        processesForm = getInstance();

        processesForm.perProc.setSelected(false);
        processesForm.perSystem.setSelected(false);
    }

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayoutManager(2, 1, new Insets(20, 20, 20, 20), -1, -1));
		final JScrollPane scrollPane1 = new JScrollPane();
		mainPanel.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		processTable = new JTable();
		scrollPane1.setViewportView(processTable);
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayoutManager(1, 8, new Insets(0, 0, 10, 0), -1, -1));
		mainPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		final JLabel label1 = new JLabel();
		label1.setText("Sort by: ");
		panel1.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final Spacer spacer1 = new Spacer();
		panel1.add(spacer1, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
		final JLabel label2 = new JLabel();
		label2.setText("CPU %: ");
		panel1.add(label2, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		cpuButton = new JRadioButton();
		cpuButton.setText("CPU %");
		panel1.add(cpuButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		cumulativeCpuButton = new JRadioButton();
		cumulativeCpuButton.setText("Cumulative CPU");
		panel1.add(cumulativeCpuButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		memButton = new JRadioButton();
		memButton.setText("Memory %");
		panel1.add(memButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		perProc = new JRadioButton();
		perProc.setText("of one Processor");
		panel1.add(perProc, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		perSystem = new JRadioButton();
		perSystem.setText("of System");
		panel1.add(perSystem, new GridConstraints(0, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return mainPanel;
	}

}
