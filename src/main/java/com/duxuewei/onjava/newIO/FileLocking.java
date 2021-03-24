package com.duxuewei.onjava.newIO;

// newio/FileLocking.java
// (c)2017 MindView LLC: see Copyright.txt
// 我们无法保证该代码是否适用于其他用途。
// 访问 http://OnJava8.com 了解更多本书信息。
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.concurrent.*;
import java.io.*;

/**
 * [文件锁定]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-07-6, 周一, 16:52]
 * @Version: [v1.0.0]
 */
public class FileLocking {
    public static void main(String[] args) {
        try(
                FileOutputStream fos =
                        new FileOutputStream("file.txt");
                FileInputStream fis =
                        new FileInputStream("file.txt");
                FileChannel outChannel = fos.getChannel();
                FileChannel inChannel = fis.getChannel();
                FileLock fl = outChannel.tryLock()
        ) {
            if(fl != null) {
                System.out.println("Locked File");
                outChannel.write(ByteBuffer.wrap("hello world!!!".getBytes()));
                TimeUnit.MILLISECONDS.sleep(1000);
                fl.release();
                System.out.println("Released Lock");
                /**
                 * Exception in thread "main" java.lang.RuntimeException: java.io.IOException: 另一个程序已锁定文件的一部分，进程无法访问。
                 * 	at com.duxuewei.onjava.newIO.FileLocking.main(FileLocking.java:43)
                 * Caused by: java.io.IOException: 另一个程序已锁定文件的一部分，进程无法访问。
                 * 	at sun.nio.ch.FileDispatcherImpl.read0(Native Method)
                 * 	at sun.nio.ch.FileDispatcherImpl.read(FileDispatcherImpl.java:61)
                 * 	at sun.nio.ch.IOUtil.readIntoNativeBuffer(IOUtil.java:223)
                 * 	at sun.nio.ch.IOUtil.read(IOUtil.java:197)
                 * 	at sun.nio.ch.FileChannelImpl.read(FileChannelImpl.java:159)
                 * 	at com.duxuewei.onjava.newIO.FileLocking.main(FileLocking.java:34)
                 */
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                inChannel.read(buffer);
                buffer.flip();
                while (buffer.hasRemaining()){
                    System.out.print((char)buffer.get());
                }
            }
        } catch(IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
