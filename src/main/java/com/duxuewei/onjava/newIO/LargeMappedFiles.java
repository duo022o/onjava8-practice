package com.duxuewei.onjava.newIO;

// newio/LargeMappedFiles.java
// (c)2017 MindView LLC: see Copyright.txt
// 我们无法保证该代码是否适用于其他用途。
// 访问 http://OnJava8.com 了解更多本书信息。
// 使用内存映射来创建一个大文件
import java.nio.*;
import java.nio.channels.*;
import java.io.*;

/**
 * [内存映射文件]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-07-6, 周一, 15:9]
 * @Version: [v1.0.0]
 */
public class LargeMappedFiles {
    /** 128 MB */
    static int length = 0x8000000;

    public static void main(String[] args) throws Exception {
        try(
                RandomAccessFile tdat =
                        new RandomAccessFile("args.txt", "rw")
        ) {
            MappedByteBuffer out = tdat.getChannel().map(
                    FileChannel.MapMode.READ_WRITE, 0, length);
            /// for(int i = 0; i < length; i++) {
            ///     out.put((byte)'x');
            /// }
            /// System.out.println("Finished writing");
            /// for(int i = length/2; i < length/2 + 6; i++) {
            ///     System.out.print((char)out.get(i));
            /// }
            for(int i = 6; i >= 0; i--) {
                System.out.print((char)out.get(i));
            }
        }
    }
}