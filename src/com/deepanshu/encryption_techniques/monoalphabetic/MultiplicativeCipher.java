package com.deepanshu.encryption_techniques.monoalphabetic;

public class MultiplicativeCipher {
    final String[] aplhabets = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public String encrypt(String plain_text,int key) {
        StringBuilder sb = new StringBuilder();
        String cipher_text;
        for(char ch: plain_text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                cipher_text = aplhabets[(((int)ch- 65)* key) % 26];
                sb.append(cipher_text);
            } else {
                cipher_text = aplhabets[(((int)ch - 97)* key) % 26];
                sb.append(cipher_text);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       MultiplicativeCipher obj = new MultiplicativeCipher();
        System.out.println(obj.encrypt("INFORMATION",15));
    }
}
