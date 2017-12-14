package com.isr.finalisrlogin.controller;


import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 *
 * @author Bhagya Perera
 */
public class Encryption {

    static Logger logger = Logger.getLogger(Encryption.class);
    private static final char[] PASSWORD = "enfldsHGHEDAKgbnlsngdlkssihdgvdsjjhjsdfsjhdhjsdhaghdliUTCSDbfgvsdhdsgm".toCharArray();
    private static final byte[] SALT = {
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,};

    public static String encrypt(String property) {
        String returnValue = null;
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
            returnValue = base64Encode(pbeCipher.doFinal(property.getBytes()));
        } catch (Exception e) {
            logger.error("Threw a Exception in Encryption.encrypt() Method :- ", e);
        }
        return returnValue;
    }

    private static String base64Encode(byte[] bytes) {
        return new BASE64Encoder().encode(bytes);
    }

    public static String decrypt(String property) {
        String returnValue = null;
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
            returnValue = new String(pbeCipher.doFinal(base64Decode(property)));
        } catch (Exception e) {
            logger.error("Threw a Exception in Encryption.decrypt() Method :- ", e);
        }
        return returnValue;
    }

    private static byte[] base64Decode(String property) throws IOException {
        return new BASE64Decoder().decodeBuffer(property);
    }
}
