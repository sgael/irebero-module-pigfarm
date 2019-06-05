///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.irebero.util;
//
//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import static org.apache.tomcat.util.buf.HexUtils.toHexString;
//
///**
// *
// * @author Administrator
// */
//public class PasswordEncrypter {
//
//    public static String ecrypt(String msg) throws Exception {
//        String encMsg = "";
//        MessageDigest md5 = null;
//        md5 = MessageDigest.getInstance("MD5");
//        md5.update(msg.getBytes());
//        for (int b : md5.digest()) {
//            b = b & 0xFF;
//            if (b < 16) {
//                encMsg += "0";
//            }
//            encMsg += Integer.toString(b, 16).toUpperCase();
//        }
//        return encMsg;
//    }
//
//    public static String randomNumberGenerator() {
//        return new BigInteger(130, new SecureRandom()).toString().substring(0, 5);
//    }
//
//    /**
//     * Generate a random salt for use with the cipher.
//     *
//     * @return String version of the 12 byte salt
//     * @throws java.security.NoSuchAlgorithmException
//     */
//    public static String generateSalt() throws NoSuchAlgorithmException {
//        byte[] salt = null;
//        salt = "itdc@SYS=2".getBytes();
//        return toHexString(salt);
//    }
//}
