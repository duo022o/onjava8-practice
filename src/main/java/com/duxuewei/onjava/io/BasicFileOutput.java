package com.duxuewei.onjava.io;

// iostreams/BasicFileOutput.java
// {VisuallyInspectOutput}
import java.io.*;

/**
 * [基本的文件输出]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-06-29, 周一, 21:56]
 * @Version: [v1.0.0]
 */
public class BasicFileOutput {
    static String file = "BasicFileOutput.dat";

    public static void main(String[] args) {
        try (
                BufferedReader in = new BufferedReader(
                        new StringReader(
                                BufferedInputFile.read(
                                        "src/main/java/com/duxuewei/onjava/io/BasicFileOutput.java")));
                PrintWriter out = new PrintWriter(
                        new BufferedWriter(new FileWriter(file)))
        ) {
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
}
