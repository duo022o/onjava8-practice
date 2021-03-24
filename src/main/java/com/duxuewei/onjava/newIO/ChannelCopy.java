package com.duxuewei.onjava.newIO;

// newio/ChannelCopy.java

// 使用 channels and buffers 移动文件
// {java ChannelCopy ChannelCopy.java test.txt}
import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class ChannelCopy {
    private static final int BSIZE = 2;
    public static void main(String[] args) {
        args = new String[2];
        args[0] = "args.txt";
        args[1] = "args2.txt";
        if(args.length != 2) {
            System.out.println(
                    "arguments: sourcefile destfile");
            System.exit(1);
        }
        try(
                FileChannel in = new FileInputStream(
                        args[0]).getChannel();
                FileChannel out = new FileOutputStream(
                        args[1]).getChannel()
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
            while(in.read(buffer) != -1) {
                buffer.flip(); // 准备写入
                out.write(buffer);
                buffer.clear();  // 准备读取
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}

