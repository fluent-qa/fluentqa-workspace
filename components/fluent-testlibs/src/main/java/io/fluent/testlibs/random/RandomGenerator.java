package io.fluent.testlibs.random;


import com.google.common.collect.Lists;

import java.util.*;
import java.util.regex.Pattern;


/**
 * 随机数生成工具，包括
 * 1. 移动号码
 * 2. 用户名
 * 3. 密码
 * 4. 地址
 */
public class RandomGenerator {

    private static RandomGenerator instance = new RandomGenerator();
    private static Random random = new Random();
    private static final String NUMBERS = "0123456789";
    private static final Map<String, List<String>> MOBILE_OPERATOR_MAP = new HashMap<String, List<String>>();

    static {
        MOBILE_OPERATOR_MAP.put("CM", Lists.newArrayList("137", "138", "139"));
        MOBILE_OPERATOR_MAP.put("CU", Lists.newArrayList("186", "187", "189", "188"));
        MOBILE_OPERATOR_MAP.put("CT", Lists.newArrayList("150", "151", "152", "153"));
    }

    private static final List<String> USERNAME_PREFIX = Lists.newArrayList("tn", "nt", "at");
    private static final List<String> USERNAME_POSTFIX = Lists.newArrayList("t", "s", "n");

    public static RandomGenerator getInstance() {
        return instance;
    }

    private RandomGenerator() {
    }

    /**
     * 生成随机手机号码
     *
     * @return
     */
    public static String generateMobilePhoneNumber() {
        return generateMobilePhoneNumber(11);
    }


    /**
     * 生成随机手机号码
     *
     * @param digital
     * @return
     */
    public static String generateMobilePhoneNumber(int digital) {
        StringBuilder sb = new StringBuilder();
        //todo 目前默认是CU
        String mobile_prefix = MOBILE_OPERATOR_MAP.get("CU").get(random.
                nextInt(MOBILE_OPERATOR_MAP.get("CU").size()));
        sb.append(mobile_prefix);
        for (int i = 0; i < digital - 3; i++) {
            sb.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }

        return sb.toString();
    }

    /**
     * 生成随机用户名
     *
     * @return
     */
    public static String generateUserName() {
        StringBuilder sb = new StringBuilder();
        String prefix = USERNAME_PREFIX.get(random.nextInt(USERNAME_PREFIX.size()));
        sb.append(prefix);
        for (int i = 0; i < 3; i++) {
            sb.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }
        sb.append(USERNAME_POSTFIX.get(random.nextInt(USERNAME_POSTFIX.size())));
        return sb.toString();
    }

    /**
     * 生成年纪
     *
     * @return
     */
    public static int generateAge() { //more thank 18 and less than 40
        int age = 18;
        age = age + random.nextInt(40 - 18);
        return age;
    }

    /**
     * 生日年份
     *
     * @param age
     * @return
     */
    public static int getBirthYear(int age) {
        return Calendar.getInstance().get(Calendar.YEAR) - age;
    }

    /**
     * 随机生日月份
     *
     * @return
     */
    public static int getBirthMonth() {
        return random.nextInt(13);
    }

    /**
     * 生日日期
     *
     * @param month
     * @param year
     * @return
     */
    public static int getBirthDay(int month, int year) {
        if (month == 2) {
            if (year % 4 == 0 && year % 100 != 0) {
                return random.nextInt(28); //闰年
            } else {
                return random.nextInt(29);
            }
        }

        List<Integer> month1 = Lists.newArrayList(1, 3, 5, 7, 8, 10, 12);
        List<Integer> month2 = Lists.newArrayList(4, 6, 9, 11);
        if (month1.contains(month)) {
            return random.nextInt(31);
        }

        if (month2.contains(month)) {
            return random.nextInt(30);
        }

        return random.nextInt(28);
    }

    /**
     * 身份证号码
     *
     * @param age
     * @return
     */
    public static String generateIdCardNumberByAge(int age) {
        IdCardGenerator generator = new IdCardGenerator();
        return generator.generate(age);

    }

    /**
     * 身份证号码
     *
     * @return
     */
    public static String generateIdCardNumber() {

        IdCardGenerator generator = new IdCardGenerator();
        return generator.generate(generateAge());

    }

    /**
     * 随机号
     *
     * @return
     */
    public static String generateReferenceId() {

        return String.valueOf(random.nextInt(1000000));
    }

    /**
     * 随机QQ号
     *
     * @return
     */
    public static String generateQQNumber() {
        return String.valueOf(random.nextInt(100000));
    }

    /**
     * 随机数
     *
     * @param length
     * @return
     */
    public static String generateRandomValue(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }

        return sb.toString();

    }

    public static int generateRandomInt(int bound) {
        return random.nextInt(bound);
    }

    /**
     * 获取某个范围内的int 值
     *
     * @param min
     * @param max
     * @return
     */
    public static int getFixedLengthInt(final int min, final int max) {
        if (Integer.MIN_VALUE == min) return 0;
        int tmp = Math.abs(random.nextInt());
        return tmp % (max - min + 1) + min;
    }

    /**
     * 获取某个范围内的int 值
     *
     * @param min
     * @param max
     * @return
     */
    public static String getNumAsString(final int min, final int max) {
        if (Integer.MIN_VALUE == min) return "0";
        int tmp = Math.abs(random.nextInt());
        return String.valueOf(tmp % (max - min + 1) + min);
    }


    private static final Pattern UUID_PATTERN = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static boolean hasMatchingUUID(String timeToken, String oneTimeToken) {
        boolean userTokenValid = UUID_PATTERN.matcher(oneTimeToken).matches();
        //boolean userTokenValid = oneTimeToken != null && timeToken != null && UUID_PATTERN.matcher(oneTimeToken).matches();
        boolean matchingTokenValid = oneTimeToken != null && UUID_PATTERN.matcher(oneTimeToken).matches();
        return userTokenValid && matchingTokenValid && timeToken.equals(oneTimeToken);
    }

    /**
     * 或者指定列表的随机值
     *
     * @param source
     * @return
     */
    public static String getRandomFrom(List<String> source) {
        if (source.size() == 0) throw new RuntimeException("输入必须有值");
        int size = source.size();
        return source.get(RandomGenerator.generateRandomInt(size));
    }

    /**
     * 或者指定数组的随机值
     *
     * @param source
     * @return
     */
    public static String getRandomFrom(String[] source) {
        if (source.length == 0) throw new RuntimeException("输入数组必须有值");
        int size = source.length;
        return source[RandomGenerator.generateRandomInt(size)];
    }


}
