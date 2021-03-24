package com.duxuewei.onjava.string;

/**
 * [字符串的转置]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-04-23, 周四, 9:19]
 * @Version: [v1.0.0]
 */
public class ToCharArray {

    public static void main(String[] args) {

        String s = "nihao";
        char[] chars = s.toCharArray();
        int count = chars.length / 2;
        char n = 0;
        for (int i = 0; i < count; i++) {
            n = chars[i];
            chars[i] = chars[2*count-i];
            chars[2*count-i] = n;
        }

        System.err.println(s);
        System.err.println(chars);
    }

}
