package com.duxuewei.onjava.intdemo;

public class IntShortDemo {

    public static void main(String[] args) {
        // short s = Short.MAX_VALUE;
        // int i = Short.MAX_VALUE+Short.MAX_VALUE+Short.MAX_VALUE+2;
        // System.err.println(s==(short)i);

        long l = Integer.MAX_VALUE+Integer.MAX_VALUE+3;
        int i = 1;
        System.err.println(i==l);
    }

}
