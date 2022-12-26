package com.codingworld.encryptdecryptrsa;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Component
public class AESEncryption {
    static Key SessionKey1;
    private static String encryptedData;


    public AESEncryption() {

    }

    public static Key GetSymmetricSessionKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            int keyBitSize = 256;
            keyGenerator.init(keyBitSize, secureRandom);
            SessionKey1 = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return SessionKey1;
    }

    public static String EncryptData(String plaintext) {
        if (plaintext == null)
            return null;
        Key Sessionkey1 = AESEncryption.GetSymmetricSessionKey();

        try {

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, Sessionkey1);

            byte[] cipherText = cipher.doFinal(plaintext.getBytes());

            encryptedData = Base64.getEncoder()
                    .encodeToString(cipherText);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedData;


    }

    public static String DecryptDataSymmetrically(String encryptedData) {
        String decryptedText = "";

        try {
            byte[] decodeData = Base64.getDecoder().decode(encryptedData);

            Cipher Decipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            Decipher.init(Cipher.DECRYPT_MODE, SessionKey1);

            byte[] cipherText = Decipher.doFinal(decodeData);
//            System.out.println("Main Response=====>" + new String(cipherText));
            decryptedText = new String(cipherText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;


    }
}
