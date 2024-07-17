package io.fluent.builtin;

import java.math.BigDecimal;

public class BigDecimalUtil {

    //-1
    public static final BigDecimal NEGATIVE_ONE = BigDecimal.valueOf(-1);
    public static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);
    public static final BigDecimal ONE_HUNDREDTH = new BigDecimal("0.01");
    public static final BigDecimal HOUR_8 = BigDecimal.valueOf(8);

    public static boolean isEmpty(BigDecimal bigDecimal) {

        return bigDecimal == null || BigDecimal.ZERO.compareTo(bigDecimal) == 0;
    }
}
