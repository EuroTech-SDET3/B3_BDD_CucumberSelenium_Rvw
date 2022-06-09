package com.demoblaze.utulities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtils {
    private static SecretKeySpec _keySpec;
    private static byte[] i;

    /*
     Cipher class provides cryptographic encryption and decryption functionality in Java.
     The Cipher class — located in the javax.crypto package —
     providing the functionality for encryption and decryption.
     */

    public EncryptionUtils() {
    }

    public static void setKey(String myKey) {
        try {
            i = myKey.getBytes("UTF-8");
            i = Arrays.copyOf(i = MessageDigest.getInstance("SHA-1").digest(i), 16);
            _keySpec = new SecretKeySpec(i, "AES");
        } catch (NoSuchAlgorithmException var1) {
            var1.printStackTrace();
        } catch (UnsupportedEncodingException var2) {
            var2.printStackTrace();
        }
    }

    public static String encrypt(String strToEncrypt, String mySecretKey) {
        try {
            setKey(mySecretKey);

            Cipher myCipher1;
            //_KeysSpec the secret key encapsulated by the KeySpec class
            // MySecretKey1 is the instinctive Cipher we gonna use for encryption
            (myCipher1 = Cipher.getInstance("AES/ECB/PKCS5Padding")).init(Cipher.ENCRYPT_MODE, _keySpec);

            /*
            doFinal
            Encrypts or decrypts data in a single-part operation, or finishes a multiple-part operation.
            The data is encrypted or decrypted, depending on how this cipher was initialized.
             */

            byte[] temp = myCipher1.doFinal(strToEncrypt.getBytes("UTF-8"));

            /*
            we need String and we should convert to String from byte and we use getEncoder method.
             */
            return Base64.getEncoder().encodeToString(temp);

        } catch (Exception var2) {
            System.err.println("[INFO]: Error while encrypting: " + var2.toString());
            return null;
        }
    }

    public static String decrypt(String strToDecrypt, String mySecretKey) {
        try {
            setKey(mySecretKey);
            Cipher myCipher1;
            (myCipher1 = Cipher.getInstance("AES/ECB/PKCS5PADDING")).init(Cipher.DECRYPT_MODE, _keySpec);
            return new String(myCipher1.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception var2) {
            System.out.println("Error while decrypting: " + var2.toString());
            return null;
        }
    }

}

