package com.duxuewei.onjava.io;

// iostreams/FileOutputShortcut.java
// {VisuallyInspectOutput}
import java.io.*;

/**
 * [快速输出文本文件]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-06-30, 周二, 9:27]
 * @Version: [v1.0.0]
 */
public class FileOutputShortcut {
    static String file = "FileOutputShortcut.dat";

    public static void main(String[] args) {
        try (
                BufferedReader in = new BufferedReader(
                        new StringReader(BufferedInputFile.read(
                                "src/main/java/com/duxuewei/onjava/io/FileOutputShortcut.java")));
                // Here's the shortcut:
                PrintWriter out = new PrintWriter(file)
        ) {
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(BufferedInputFile.read(file));
    }
}
