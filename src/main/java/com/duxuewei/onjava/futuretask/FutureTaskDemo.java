package com.duxuewei.onjava.futuretask;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * [测试异步线程]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-06-2, 周二, 16:9]
 * @Version: [v1.0.0]
 */
public class FutureTaskDemo {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long b = DateUtil.currentSeconds();
        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int i = 1/0;
            return "123123";
        });

        System.out.println("主线程开始");
        Thread.sleep(3000L);
        System.out.println("主线程结束");
        System.out.println("获取异步结果");
        final String aa = future.get();
        System.out.println("异步结束：等待异步线程，合并："+aa);

        long e = DateUtil.currentSeconds();

        System.err.println(e-b);

    }

    /*public static void main(String[] args) throws InterruptedException, ExecutionException {
        long b = DateUtil.currentSeconds();
        System.out.println("程序开始");
        FutureTask task = new FutureTask(()->{
            Thread.sleep(3000L);
            int i = 1/0;
            return 123;
        });
        System.out.println("异步开始");
        new Thread(task).start();
        System.out.println("主线程开始");
        Thread.sleep(1000L);
        System.out.println("主线程结束");
        System.out.println("获取异步结果");
        Object o = task.get();
        System.out.println("异步结束：等待异步线程，合并："+o);

        long e = DateUtil.currentSeconds();

        System.err.println(e-b);

    }*/

}
