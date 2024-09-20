package io.fluent.pcinfo.util;

import java.io.File;

/**
 * System util
 *
 * @author <a href="https://github.com/rememberber">RememBerBer</a>
 * @since 2021/11/08.
 */
public class SystemUtil {
    private static final String OS_NAME = System.getProperty("os.name");
    private static final String OS_ARCH = System.getProperty("os.arch");
    private static final String VM_VENDOR = System.getProperty("java.vm.vendor");
    private static final String USER_HOME = System.getProperty("user.home");
    public static final String CONFIG_HOME = USER_HOME + File.separator + ".MooInfo";

    /**
     * log file dir
     */
    public final static String LOG_DIR = USER_HOME + File.separator + ".MooInfo" + File.separator + "logs" + File.separator;

    public static boolean isMacOs() {
        return OS_NAME.contains("Mac");
    }

    public static boolean isMacM1() {
        return OS_NAME.contains("Mac") && "aarch64".equals(OS_ARCH);
    }

    public static boolean isWindowsOs() {
        return OS_NAME.contains("Windows");
    }

    public static boolean isLinuxOs() {
        return OS_NAME.contains("Linux");
    }

    public static boolean isJBR() {
        return VM_VENDOR.contains("JetBrains");
    }
}