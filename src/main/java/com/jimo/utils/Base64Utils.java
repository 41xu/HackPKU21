package com.jimo.utils;

public class Base64Utils {
    private static String codeStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxzy0123456789+/";
    private static char[] code = codeStr.toCharArray();
    /** * 对字符串进行Base64编码
     * * @param str
     * * @return
     * */
    public static String encode(String str) {
        if(str == null) {
            throw new NullPointerException();
        }
        StringBuffer result = new StringBuffer();
        // 字符串转为二进制
        String binStr = str2Bin(str);
        // 6bit 为一个单元，需要补0的位数
        int tail = binStr.length() % 6;
        if(tail != 0) {
            //最后剩2bit，需要补4位，剩4位需要补2bit
            tail = 6 - tail;
        }
        for(int i = 0; i < tail; i++) {
            binStr += "0";
        }
        for(int i = 0; i < binStr.length() / 6; i++) {
            int beginIndex = i * 6;
            String s = binStr.substring(beginIndex, beginIndex+6);
            // 二进制转十进制
            int codePoint = Integer.valueOf(s, 2);
            // 对应的字符
            char c = code[codePoint];
            result.append(c);
        }
        // 需要补=的位数
        int groupNum = binStr.length() / 6;
        // 6bit为一组
        if((groupNum % 4) != 0) {
            tail = 4 - groupNum % 4;
        }
        for(int i = 0; i < tail; i++) {
            result.append("=");
        }
        return result.toString();
    }
    /**
     * * base64解码 * @param str * @return
     * */
    public static String decode(String str) {
        if(str == null) {
            throw new NullPointerException();
        }
        StringBuffer result = new StringBuffer();
        // 去除末尾的'='
        int index = str.indexOf("=");
        if (index >= 0) {
            str = str.substring(0, index);
        }
        // base64字符串转换为二进制
        String binStr = base64Str2Bin(str);
        // 将二进制按8bit一组还原成原字符
        for(int i = 0; i < binStr.length() / 8; i++) {
            int beginIndex = i * 8;
            String s = binStr.substring(beginIndex, beginIndex+8);
            String c = bin2Str(s); result.append(c);
        }
        return result.toString();
    }
    /**
     * * 字符串转换为二进制字符串
     * * @param str
     * * @return
     * */
    private static String str2Bin(String str) {
        StringBuffer sb = new StringBuffer();
        // 字符串转为字符数组
        char[] c = str.toCharArray();
        for(int i = 0; i < c.length; i++) {
            // 将每个字符转换为二进制
            String s = Integer.toBinaryString(c[i]);
            // 需要补0的长度
            int len = 8 - s.length();
            for(int j = 0; j < len; j++) {
                s = "0" + s;
            } sb.append(s);
        }
        return sb.toString();
    }
    /**
     * * Base64字符串转换为二进制字符串
     * * @param str * @return
     * */
    private static String base64Str2Bin(String str) {
        StringBuffer sb = new StringBuffer();
        // 字符串转为字符数组
        char[] c = str.toCharArray();
        for(int i = 0; i < c.length; i++) {
            // 将每个字符转换为二进制
            int index = codeStr.indexOf(c[i]);
            String s = Integer.toBinaryString(index);
            // 需要补0的长度
            int len = 6 - s.length();
            for(int j = 0; j < len; j++) {
                s = "0" + s;
            }
            sb.append(s);
        } return sb.toString();
    }
    /**
     * * 二进制转换为字符串
     * * @param binStr
     * * @return
     * */
    private static String bin2Str(String binStr) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < binStr.length() / 8; i++) {
            int beginIndex = i * 8;
            String s = binStr.substring(beginIndex, beginIndex+8);
            // 二进制转十进制
            int codePoint = Integer.valueOf(s, 2);
            // 对应的字符
            char c = Character.toChars(codePoint)[0]; sb.append(c);
        }
        return sb.toString();
    }

}