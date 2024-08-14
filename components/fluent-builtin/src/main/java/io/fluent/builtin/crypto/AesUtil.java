package io.fluent.builtin.crypto;


import io.fluent.builtin.exception.EncryptException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * AES-128-CBC 算法
 * iv 默认取key
 */
public class AesUtil {

    /**
     * AES
     */
    static String ALGORITHM = "AES";
    /**
     * AES 算法
     */
    static String AES_CBC_CIPHER = "AES/CBC/PKCS5Padding";
    /**
     * 偏移量
     */
    private static final int OFFSET = 16;


    /**
     * 加密
     *
     * @param data 需要加密的内容
     * @param key  加密密码
     * @param iv   加密密码
     * @return
     */
    public static byte[] encrypt(byte[] data, byte[] key, byte[] iv) {
        try {
            if (key.length < OFFSET) {
                byte[] tmp = new byte[OFFSET];
                System.arraycopy(key, 0, tmp, 0, key.length);
                key = tmp;
            }
            if (iv.length < 16) {
                byte[] tmp = new byte[16];
                System.arraycopy(iv, 0, tmp, 0, iv.length);
                iv = tmp;
            }
            SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv, 0, OFFSET);
            Cipher cipher = Cipher.getInstance(AES_CBC_CIPHER);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new EncryptException("aes encrypt error:" + e.getMessage(), e);
        }
    }

    /**
     * 解密
     *
     * @param data 待解密内容
     * @param key  解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] data, byte[] key, byte[] iv) {
        try {
            if (key.length < 16) {
                byte[] tmp = new byte[16];
                System.arraycopy(key, 0, tmp, 0, key.length);
                key = tmp;
            }
            if (iv.length < 16) {
                byte[] tmp = new byte[16];
                System.arraycopy(iv, 0, tmp, 0, iv.length);
                iv = tmp;
            }
            SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv, 0, OFFSET);
            Cipher cipher = Cipher.getInstance(AES_CBC_CIPHER);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new EncryptException("ase decrypt error", e);
        }
    }

    /**
     * 加密
     * <p>
     * * 定义 aes 加密的key
     * * 密钥  必须是16位, 自定义,
     * * 如果不是16位, 则会出现InvalidKeyException: Illegal key size
     * * 解决方案有两种：
     * * 需要安装Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files(可以在Oracle下载).
     * * .设置设置key的长度为16个字母和数字的字符窜（128 Bit/8=16字符）就不报错了。
     *
     * @param data 需要加密的内容
     * @param key  加密密码
     * @return
     */
    public static String encrypt(String data, String key) {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        byte[] valueByte = encrypt(data.getBytes(StandardCharsets.UTF_8), keyBytes, keyBytes);
        return Base64.getEncoder().encodeToString(valueByte);
    }

    /**
     * 解密
     *
     * @param data 待解密内容 base64 字符串
     * @param key  解密密钥
     * @return
     */
    public static String decrypt(String data, String key) {
        byte[] originalData = Base64.getDecoder().decode(data.getBytes());
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        byte[] valueByte = decrypt(originalData, keyBytes, keyBytes);
        return new String(valueByte);
    }
}
