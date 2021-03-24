package com.duxuewei.onjava.io;
// iostreams/MemoryInput.java
// {VisuallyInspectOutput}
import java.io.*;

/**
 * [内存中读取]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-06-29, 周一, 21:19]
 * @Version: [v1.0.0]
 */
public class MemoryInput {
    public static void
    main(String[] args) throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read("src/main/java/com/duxuewei/onjava/io/MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1)
            System.out.print((char) c);
    }
}
