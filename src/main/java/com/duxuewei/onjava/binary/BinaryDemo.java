package com.duxuewei.onjava.binary;

/**
 * 二进制运算
 */
public class BinaryDemo {

    public static void main(String[] args) {
        System.err.println(String.format("0b100 & 0b010 = %s",Integer.toBinaryString(0b100 & 0b010)));
        System.err.println(String.format("0b100 | 0b010 = %s",Integer.toBinaryString(0b100 | 0b010)));
        System.err.println(String.format("0b1100 ^ 0b1010 = %s",Integer.toBinaryString(0b1100 ^ 0b1010)));
        System.err.println(String.format(" ~ 0b1010 = %s",Integer.toBinaryString( ~ 0b1010)));
        System.err.println(String.format("0b010 << 1 = %s",Integer.toBinaryString(0b010 << 1)));
        System.err.println(String.format("0b010 >> 1 = %s",Integer.toBinaryString(0b010 >> 1)));
        System.err.println(String.format("0b0101000 >>> 1 = %s",Integer.toBinaryString(0b0101000 >>> 1)));
    }

}
