package com.duxuewei.onjava.newIO;

// newio/LockingMappedFiles.java
// (c)2017 MindView LLC: see Copyright.txt
// 我们无法保证该代码是否适用于其他用途。
// 访问 http://OnJava8.com 了解更多本书信息。
// Locking portions of a mapped file
import java.nio.*;
import java.nio.channels.*;
import java.io.*;

/**
 * [映射文件的获取部分锁]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-07-6, 周一, 22:4]
 * @Version: [v1.0.0]
 */
public class LockingMappedFiles {
    /** 128 MB */
    static final int LENGTH = 0x8FFFFFF; 
    static FileChannel fc;
    public static void
    main(String[] args) throws Exception {
        fc = new RandomAccessFile("test.dat", "rw")
                .getChannel();
        MappedByteBuffer out = fc.map(
                FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for(int i = 0; i < LENGTH; i++)
            out.put((byte)'x');
        new LockAndModify(out, 0, 0 + LENGTH/3);
        new LockAndModify(
                out, LENGTH/2, LENGTH/2 + LENGTH/4);
    }

    private static class LockAndModify extends Thread {
        private final ByteBuffer buff;
        private final int start;
        private final int end;
        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            buff = mbb.slice();
            start();
        }

        @Override
        public void run() {
            try {
                // Exclusive lock with no overlap:
                FileLock fl = fc.lock(start, end, false);
                System.out.println(
                        "Locked: "+ start +" to "+ end);
                // Perform modification:
                while(buff.position() < buff.limit() - 1)
                    buff.put((byte)(buff.get() + 1));
                fl.release();
                System.out.println(
                        "Released: " + start + " to " + end);
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
