package com.duxuewei.onjava.file;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;

public class RmDir {

    /**
     * 删除多级目录下的文件
     * @param dir
     * @throws IOException
     */
    public static void rmdir(Path dir) throws IOException {
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        // 获取测试目录
        Path path = Paths.get("E:", "demo");
        System.err.println(path.getFileName());
        try {
            rmdir(path);
            // Files.delete(path);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}