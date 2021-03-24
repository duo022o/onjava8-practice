package com.duxuewei.onjava.io;

// iostreams/FormattedMemoryInput.java
// {VisuallyInspectOutput}
import java.io.*;

/**
 * [格式化内存输入]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-06-29, 周一, 21:31]
 * @Version: [v1.0.0]
 */
public class FormattedMemoryInput {
    public static void main(String[] args) {
        // 通过字节可以读取任何数据
        try (
                DataInputStream in = new DataInputStream(
                        new ByteArrayInputStream(
                                BufferedInputFile.read(
                                        "src/main/java/com/duxuewei/onjava/io/FormattedMemoryInput.java")
                                        .getBytes()))
        ) {
            while (true)
                System.out.write((char) in.readByte());
        } catch (EOFException e) {
            System.out.println("\nEnd of stream");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
