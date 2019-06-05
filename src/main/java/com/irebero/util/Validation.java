///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.irebero.util;
//
//import java.text.DecimalFormat;
//import java.util.*;
//import java.util.regex.*;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
///**
// *
// * @author mcpaul
// */
//public class Validation {
//
//    private static Log LOGGER = LogFactory.getLog(Validation.class);
//    private static final String STRING_PATTERN = "^[a-zA-Z_0-9_ ]{1,20}$";
//    private static Pattern pattern;
//    private static Matcher matcher;
//
//    public Validation() {
//        pattern = Pattern.compile(STRING_PATTERN);
//    }
//
//    /**
//     *
//     * @param o
//     * @return true if it object is null
//     */
//    public static boolean isObjectNull(Object o) {
//        boolean valid = false;
//        if (o == null) {
//            valid = true;
//        }
//        return valid;
//    }
//
//    /**
//     *
//     * @param list
//     * @return true if list is null or empty
//     */
//    public static boolean isListNullOrEmpty(List<Object> list) {
//        boolean valid = false;
//        if (list == null || list.isEmpty()) {
//            valid = true;
//        }
//        return valid;
//    }
//
//    public static double formatDouble(double value) {
//        double valid = 0;
//        try {
//            String doubleString = new DecimalFormat("###.##").format(value);
//            valid = Double.parseDouble(doubleString);
//            return valid;
//        } catch (NumberFormatException e) {
//            LOGGER.error("NumberFormatException" + e.toString());
//            return valid;
//        }
//    }
//
//    public static double formatDouble(long value) {
//        double valid = 0;
//        try {
//            String doubleString = new DecimalFormat("###.##").format(value);
//            valid = Double.parseDouble(doubleString);
//            return valid;
//        } catch (NumberFormatException e) {
//            LOGGER.error("NumberFormatException" + e.toString());
//            return valid;
//        }
//    }
//
//    public static double formatDouble(String value) {
//        double valid = 0;
//        try {
//            String doubleString = new DecimalFormat("###.##").format(Double.valueOf(value));
//            valid = Double.parseDouble(doubleString);
//            return valid;
//        } catch (NumberFormatException e) {
//            LOGGER.error("NumberFormatException" + e.toString());
//            return valid;
//        }
//    }
//
//    public static String formatDoubleReturnString(double value) {
//        return new DecimalFormat("#,###.##").format(value);
//    }
//
//
//    public Pattern getPattern() {
//        return pattern;
//    }
//
//    public void setPattern(Pattern pattern) {
//        this.pattern = pattern;
//    }
//
//    public Matcher getMatcher() {
//        return matcher;
//    }
//
//    public void setMatcher(Matcher matcher) {
//        this.matcher = matcher;
//    }
//
//    public static boolean validateString(final String name) throws Exception {
//        //pattern = Pattern.compile(STRING_PATTERN);
//        matcher = Pattern.compile(STRING_PATTERN).matcher(name);
//        boolean m = matcher.matches();
//        return m;
//    }
//
//    public static boolean validateNID(String nid) {
//        return nid.substring(5, 6).equals("7") || nid.substring(5, 6).equals("8");
//    }
//
//}
