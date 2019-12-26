package com.person.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 加密与解密工具
 *
 * @author RootAdmin/RainbowPerfect
 * @version v1.0
 * @create 2019/12/10/20:53
 */

public class DecodeUtils {

    private static Logger logger = LoggerFactory.getLogger(DecodeUtils.class);
    private static  final String IV ="1234567-";

    /**
     * @param src  数据源
     * @param key 密钥，长度必须是8的倍数
     * @return 返回解密后的原始数据
     * @throws Exception
     */
    public static String  encryptDESCBC(final String src ,final String key) throws Exception {
        // 一生成key，同时制定des还是DEScode,两者的key长度要求不同
        final DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        final SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        // 一加密向量
        final IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
        // 一通过Cipher执行加密得到的是一个byte的数组，Cipher.getInstance("DES")就是采用ECB模式，cipher.init(Cipher.ENCRYPT_MODE,secretKey)即可
        final Cipher cipher =Cipher.getInstance("DES/CBC/PKCS5padding");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey,iv);
        final  byte[] b =cipher.doFinal(src.getBytes("UTF-8"));
        // 通过base64，将加密数组转化成字符串
        final BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(b);
    }

    // 3DESECB解密，key必须是长度大于等于3*8=24

    public static  String decryptDESCBC(final String src,final  String key) throws Exception {
        final BASE64Decoder decoder = new BASE64Decoder();
        final byte[] bytes = decoder.decodeBuffer(src);

        final DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        final SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        final IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));

        final Cipher cipher =Cipher.getInstance("DES/CBC/PKCS5padding");
        cipher.init(Cipher.DECRYPT_MODE,secretKey,iv);
        final byte[] aFinal = cipher.doFinal(bytes);
        return new String(aFinal);
    }

    /**
     * @param src
     * @param key
     * @return 加密
     * @throws Exception
     */
    public static String encryptThreeDESECB(final String src, final String key) throws Exception{
        final DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
        final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        final SecretKey secretKey = keyFactory.generateSecret(dks);

        final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        final byte[] aFinal = cipher.doFinal(src.getBytes());
        final BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(aFinal).replaceAll("\r","").replaceAll("\n","");
    }

    /**
     * @param src
     * @param key
     * @return 解密
     * @throws Exception
     */
    public static String decryptThreeDESECB (final String src ,final String key ) throws Exception {
        final BASE64Decoder decoder = new BASE64Decoder();
        final byte[] bytes = decoder.decodeBuffer(src);

        final DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
        final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        final SecretKey secretKey = keyFactory.generateSecret(dks);
        // Cipher解密
        final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        final byte[] aFinal = cipher.doFinal(bytes);
        return new String(aFinal);
    }

    public static void main(String[] args) throws Exception {
        final String key ="MTIzNDU2Nzg4NzYINDMyMTEyMzQ1Njc4";
        String password ="123456";
        logger.info("原始密码:()",password);

        // 加密流程
        String pw_en = DecodeUtils.encryptDESCBC(password,key);
        logger.info("加密后的密文:{}",pw_en);
        // 解密流程
        String pw_decrypt = DecodeUtils.decryptThreeDESECB("6Nk9CZQEMgEyAIe11YDDE===", key);
        logger.info("解密后的明文:{}",pw_decrypt);
    }
}
