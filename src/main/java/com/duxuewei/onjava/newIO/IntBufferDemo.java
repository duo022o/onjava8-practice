package com.duxuewei.onjava.newIO;

// newio/IntBufferDemo.java
// (c)2017 MindView LLC: see Copyright.txt
// 我们无法保证该代码是否适用于其他用途。
// 访问 http://OnJava8.com 了解更多本书信息。
// 利用 IntBuffer 保存 int 数据到 ByteBuffer
import java.nio.*;

public class IntBufferDemo {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        // 保存 int 数组：
        ib.put(new int[]{ 11, 42, 47, 99, 143, 811, 1016 });
        //绝对位置读写：
        System.out.println(ib.get(3));
        ib.put(3, 1811);
        // 在重置缓冲区前设置新的限制

        ib.flip();
        while(ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }
    }
}
