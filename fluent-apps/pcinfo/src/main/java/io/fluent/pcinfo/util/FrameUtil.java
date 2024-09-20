package io.fluent.pcinfo.util;

import io.fluent.pcinfo.ui.UiConsts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * FrameUtil
 * </pre>
 *
 * @author <a href="https://github.com/rememberber">RememBerBer</a>
 * @since 2021/11/08.
 */
public class FrameUtil {

    public static void setFrameIcon(JFrame jFrame) {
        List<Image> images = new ArrayList<>();
        images.add(UiConsts.IMAGE_LOGO_1024);
        images.add(UiConsts.IMAGE_LOGO_512);
        images.add(UiConsts.IMAGE_LOGO_256);
        images.add(UiConsts.IMAGE_LOGO_128);
        images.add(UiConsts.IMAGE_LOGO_64);
        images.add(UiConsts.IMAGE_LOGO_48);
        images.add(UiConsts.IMAGE_LOGO_32);
        images.add(UiConsts.IMAGE_LOGO_24);
        images.add(UiConsts.IMAGE_LOGO_16);
        jFrame.setIconImages(images);
    }
}
