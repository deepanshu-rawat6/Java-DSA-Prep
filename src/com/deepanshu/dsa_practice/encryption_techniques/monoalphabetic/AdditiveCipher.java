package com.deepanshu.dsa_practice.encryption_techniques.monoalphabetic;

public class AdditiveCipher {
    final String[] aplhabets = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public String encypt(String plain_text,int key) {
        StringBuilder sb = new StringBuilder();
        String cipher_text;
        for(char ch: plain_text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                cipher_text = aplhabets[((int)ch + key - 65)%26];
                sb.append(cipher_text);
            } else {
                cipher_text = aplhabets[((int)ch + key - 97)%26];
                sb.append(cipher_text);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdditiveCipher obj = new AdditiveCipher();
        System.out.println(obj.encypt("INFORMATION",17));
    }
}
