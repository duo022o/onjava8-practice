package com.duxuewei.onjava.string;

public class StringDemo {

    public static void main(String[] args) {
        String format = String.format("%s%s", "1", "1");
        String format1 = String.format("%s-%s", null, null);
        String format2 = String.format("%d%d", 1, 1);
        System.err.println(format+format1+format2);
    }

}
