package com.epam.rd.java.basic.practice3;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

    public static void main(String[] args) {
        try {
        System.out.println(hash("abvd", "SHA-256"));

        System.out.println(hash("dsdsds", "SHA-384"));

        System.out.println(hash("asd", "SHA-1"));

        System.out.println(hash("fd", "MD5"));

        System.out.println(hash("dfd", "SHA-512"));
        }catch(Exception ex){
            
        }
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);

        byte[] byteArray = digest.digest(input.getBytes());

        BigInteger numb = new BigInteger(1, byteArray);

        return numb.toString(16).toUpperCase();
    }
}
