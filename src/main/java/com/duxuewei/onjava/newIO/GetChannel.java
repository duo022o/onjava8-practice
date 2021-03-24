package com.duxuewei.onjava.newIO;

// (c)2017 MindView LLC: see Copyright.txt
// 我们不保证这段代码用于其他用途时是否有效
// 访问 http://OnJava8.com 了解更多信息
// 从流中获取通道
import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class GetChannel {
    private static final String name = "data.txt";
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        // 写入一个文件:
        try(
                FileChannel fc = new FileOutputStream(name)
                        .getChannel()
        ) {
            fc.write(ByteBuffer
                    .wrap("Some text ".getBytes()));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        // 在文件尾添加：
        try(
                FileChannel fc = new RandomAccessFile(
                        name, "rw").getChannel()
        ) {
            // 移动到结尾
            fc.position(fc.size());
            fc.write(ByteBuffer
                    .wrap("Some more".getBytes()));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        // 读取文件e:
        try(
                FileChannel fc = new FileInputStream(name)
                        .getChannel()
        ) {
            // 获取一个新的字节缓冲区
            ByteBuffer buff = ByteBuffer.allocate(BSIZE);
            fc.read(buff);
            buff.flip();
            while(buff.hasRemaining())
                System.out.write(buff.get());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        System.out.flush();
    }
}

class Test {

    public static void main(String[] args) {
        // 读取文件e:
        try(
                FileChannel fc = new FileInputStream("data.txt")
                        .getChannel()
        ) {
            // 获取一个新的字节缓冲区
            ByteBuffer buff = ByteBuffer.allocate(1024);
            fc.read(buff);
            buff.flip();
            int position = buff.limit()-1;
            while(position>=0)
                System.out.write(buff.get(position--));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        System.out.flush();
    }

}