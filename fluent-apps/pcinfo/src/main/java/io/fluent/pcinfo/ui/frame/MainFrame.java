package io.fluent.pcinfo.ui.frame;

import com.formdev.flatlaf.extras.FlatSVGUtils;
import com.formdev.flatlaf.util.SystemInfo;
import io.fluent.pcinfo.ui.UiConsts;
import io.fluent.pcinfo.ui.component.TopMenuBar;
import io.fluent.pcinfo.ui.listener.FrameListener;
import io.fluent.pcinfo.util.ComponentUtil;
import io.fluent.pcinfo.util.SystemUtil;


import javax.swing.*;

/**
 * Main Frame
 *
 * @author <a href="https://github.com/rememberber">RememBerBer</a>
 * @since 2021/11/08.
 */
public class MainFrame extends JFrame {

    public void init() {
        this.setName(UiConsts.APP_NAME);
        this.setTitle(UiConsts.APP_NAME);
//        FrameUtil.setFrameIcon(this);
        setIconImages(FlatSVGUtils.createWindowIconImages("/icons/MooInfo.svg"));
        TopMenuBar topMenuBar = TopMenuBar.getInstance();
        topMenuBar.init();
        setJMenuBar(topMenuBar);
        ComponentUtil.setPreferSizeAndLocateToCenter(this, 0.6, 0.8);

        if (SystemUtil.isMacOs() && SystemInfo.isMacFullWindowContentSupported) {
            this.getRootPane().putClientProperty("apple.awt.fullWindowContent", true);
            this.getRootPane().putClientProperty("apple.awt.transparentTitleBar", true);
            this.getRootPane().putClientProperty("apple.awt.fullscreenable", true);
            this.getRootPane().putClientProperty("apple.awt.windowTitleVisible", false);
        }

        FrameListener.addListeners();
    }

}
