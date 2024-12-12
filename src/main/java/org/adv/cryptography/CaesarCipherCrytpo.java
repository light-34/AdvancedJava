package org.adv.cryptography;

public class CaesarCipherCrytpo {
    public static void main(String[] args) {
        String word = "crytpo";
        int shift = 3;

        String encryptedText = encryptText(word, shift);
        System.out.println("Encrypted text: " + encryptedText);

        String decryptedText = decryptText(encryptedText, shift);
        System.out.println("Decrypted text: " + decryptedText);
    }

    private static String decryptText(String encryptedText, int shift) {
       return encryptText(encryptedText, 26 - shift);
    }

    private static String encryptText(String text, int shift) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char add = (char) ((c - base + shift) % 26 + shift);
                sb.append(add);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
