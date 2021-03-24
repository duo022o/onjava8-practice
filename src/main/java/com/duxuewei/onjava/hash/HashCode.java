package com.duxuewei.onjava.hash;

public class HashCode {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            Integer integer = new Integer(i);
            int hashCode = integer.hashCode();
            System.err.println(hashCode);
            int abs = Math.abs(hashCode % 16);
            System.err.println(abs);
            System.err.println("-----------------------------------");
        }
    }

}
