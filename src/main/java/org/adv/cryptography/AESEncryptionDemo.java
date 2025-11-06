package org.adv.cryptography;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

public class AESEncryptionDemo {
    private static final String KEY_FILE = "secret.key";
    private static final String MESSAGE_FILE = "encryptedMessage.txt";

    public static void main(String[] args) {

        try {
            String message = "Hello World!";

            SecretKey secretKey = loadOrGenerateKey();

            //Encrypt Message
            String encMessage = encryptMessage(message, secretKey);
            //String encMessage = generateHmac(message, secretKey);
            System.out.println("Encrypted Message: " + encMessage);
            saveKey(MESSAGE_FILE, encMessage);

            String encMsg = loadKeyFromFile(MESSAGE_FILE);
            //Decrypt Message
            String decMessage = decryptMessage(encMsg, secretKey);
            System.out.println("Decrypted Message: " + decMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static String generateHmac(String message, SecretKey key) throws Exception {

        Mac mac = Mac.getInstance("HmacSHA512"); //"HmacSHA256"
        mac.init(key);

        byte[] rawHmac = mac.doFinal(message.getBytes());

        return Base64.getEncoder().encodeToString(rawHmac);
    }

    private static String decryptMessage(String encMessage, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptBytes = cipher.doFinal(Base64.getDecoder().decode(encMessage));

        return new String(decryptBytes);

    }

    private static String encryptMessage(String message, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptBytes = cipher.doFinal(message.getBytes());

        return Base64.getEncoder().encodeToString(encryptBytes);
    }

    private static SecretKey loadOrGenerateKey() throws Exception {
        File file = new File(KEY_FILE);

        if (!file.exists()) {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            //KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA512"); //"HmacSHA256"
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            saveKey(KEY_FILE, Base64.getEncoder().encodeToString(secretKey.getEncoded()));

            return secretKey;
        } else {
            byte[] keyBytes = loadKeyFromFile(KEY_FILE).getBytes();
            //return new SecretKeySpec(keyBytes, "HmacSHA512"); //"HmacSHA256"
            return new SecretKeySpec(keyBytes, "AES");
        }
    }

    public static void saveKey(String fileName, String secretKey) throws Exception {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
            fileOutputStream.write(secretKey.getBytes());
        }
    }

    public static String loadKeyFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        byte[] keyBytes = new byte[(int) file.length()];
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read(keyBytes);
        }
        return new String(keyBytes);
    }
}
