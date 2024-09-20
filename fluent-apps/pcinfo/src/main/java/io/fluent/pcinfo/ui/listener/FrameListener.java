package io.fluent.pcinfo.ui.listener;



import io.fluent.pcinfo.App;
import io.fluent.pcinfo.ui.Init;
import io.fluent.pcinfo.util.SystemUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Form event monitoring
 *
 * @author <a href="https://github.com/rememberber">RememBerBer</a>
 * @since 2021/11/10.
 */
public class FrameListener {


    public static void addListeners() {
        App.mainFrame.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                if (SystemUtil.isWindowsOs()) {
                    App.mainFrame.setVisible(false);
                } else {
                    App.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }

                Init.shutdown();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }
        });

        App.mainFrame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    if (App.mainFrame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                        App.mainFrame.setExtendedState(JFrame.NORMAL);
                    } else {
                        App.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

}
