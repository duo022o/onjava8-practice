package com.duxuewei.onjava.newIO;

// newio/MappedIO.java
// 我们无法保证该代码是否适用于其他用途。
// 访问 http://OnJava8.com 了解更多本书信息。
import java.util.*;
import java.nio.*;
import java.nio.channels.*;
import java.io.*;

/**
 * [映射文件访问往往要快得多]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-07-6, 周一, 16:20]
 * @Version: [v1.0.0]
 */
public class MappedIO {
    private static final int numOfInts =      4_000_000;
    private static final int numOfUbuffInts = 100_000;
    private abstract static class Tester {
        private final String name;
        Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.print(name + ": ");
            long start = System.nanoTime();
            test();
            double duration = System.nanoTime() - start;
            System.out.format("%.3f%n", duration/1.0e9);
        }

        /** Tester 使用了模板方法（Template Method）模式 */
        public abstract void test();
    }

    private static final Tester[] tests = {
            new Tester("Stream Write") {
                @Override
                public void test() {
                    try(
                            DataOutputStream dos =
                                    new DataOutputStream(
                                            new BufferedOutputStream(
                                                    new FileOutputStream(
                                                            new File("temp.tmp"))))
                    ) {
                        for(int i = 0; i < numOfInts; i++) {
                            dos.writeInt(i);
                        }
                    } catch(IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Mapped Write") {
                @Override
                public void test() {
                    try(
                            FileChannel fc =
                                    new RandomAccessFile("temp.tmp", "rw")
                                            .getChannel()
                    ) {
                        IntBuffer ib =
                                fc.map(FileChannel.MapMode.READ_WRITE,
                                        0, fc.size()).asIntBuffer();
                        for(int i = 0; i < numOfInts; i++)
                            ib.put(i);
                    } catch(IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Stream Read") {
                @Override
                public void test() {
                    try(
                            DataInputStream dis =
                                    new DataInputStream(
                                            new BufferedInputStream(
                                                    new FileInputStream("temp.tmp")))
                    ) {
                        for(int i = 0; i < numOfInts; i++)
                            System.err.println(dis.readInt());
                    } catch(IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Mapped Read") {
                @Override
                public void test() {
                    try(
                            FileChannel fc = new FileInputStream(
                                    new File("temp.tmp")).getChannel()
                    ) {
                        IntBuffer ib =
                                fc.map(FileChannel.MapMode.READ_ONLY,
                                        0, fc.size()).asIntBuffer();
                        while(ib.hasRemaining())
                            System.err.println(ib.get());
                    } catch(IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Stream Read/Write") {
                @Override
                public void test() {
                    try(
                            RandomAccessFile raf =
                                    new RandomAccessFile(
                                            new File("temp.tmp"), "rw")
                    ) {
                        raf.writeInt(1);
                        for(int i = 0; i < numOfUbuffInts; i++) {
                            raf.seek(raf.length() - 4);
                            raf.writeInt(raf.readInt());
                        }
                    } catch(IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            },
            new Tester("Mapped Read/Write") {
                @Override
                public void test() {
                    try(
                            FileChannel fc = new RandomAccessFile(
                                    new File("temp.tmp"), "rw").getChannel()
                    ) {
                        IntBuffer ib =
                                fc.map(FileChannel.MapMode.READ_WRITE,
                                        0, fc.size()).asIntBuffer();
                        ib.put(0);
                        for(int i = 1; i < numOfUbuffInts; i++)
                            ib.put(ib.get(i - 1));
                    } catch(IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
    };
    public static void main(String[] args) {
        Arrays.stream(tests).forEach(Tester::runTest);
    }
}