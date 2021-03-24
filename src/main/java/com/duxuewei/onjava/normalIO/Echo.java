package com.duxuewei.onjava.normalIO;

// standardio/Echo.java
// How to read from standard input
import java.io.*;

public class Echo {
    public static void main(String[] args) {
        TimedAbort abort = new TimedAbort(5);
        new BufferedReader(
                new InputStreamReader(System.in))
                .lines()
                .peek(ln -> abort.restart())
                .forEach(System.out::println);
        // Ctrl-Z or two seconds inactivity
        // terminates the program
    }
}