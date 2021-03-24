package com.duxuewei.onjava.conversion;

/**
 * [进制计算]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-07-16, 周四, 9:45]
 * @Version: [v1.0.0]
 */
public class Calculate {

    public static void main(String[] args) {
        /// char a = 111;
        /// char b = 000;
        /// System.err.println(a&b);
        /// System.err.println(a|b);
        // System.out.println(0b10001);
        // System.out.println(021);
        // System.out.println(17);
        // System.out.println(0x11);
        System.err.println(" 1 & 1 = " + (0b1 & 0b1));
        System.err.println(" 1 & 0 = " + (0b1 & 0b0));
        System.err.println(" 0 & 1 = " + (0b0 & 0b1));
        System.err.println(" 0 & 0 = " + (0b0 & 0b0));
        System.err.println(" 1 | 1 = " + (0b1 | 0b1));
        System.err.println(" 0 | 1 = " + (0b0 | 0b1));
        System.err.println(" 1 | 0 = " + (0b1 | 0b0));
        System.err.println(" 0 | 0 = " + (0b0 | 0b0));
        System.err.println(" 0x4 >> 1 = " + (0x4 >> 1));
        System.err.println(" 0x4 << 1 = " + (0x4 << 1));
        System.err.println(" 8 >> 2 = 8/2^2 = " + (8 >> 2));
        System.err.println(" 8 << 2 = 8*2^2 = " + (8 << 2));
        System.err.println(" 36 >> 2 = 36/2^2 = " + (36 >> 2));
        System.err.println(" 3 << 2 = 3*2^2 = " + (3 << 2));
        // System.err.println((3d>>2));
    }

}
