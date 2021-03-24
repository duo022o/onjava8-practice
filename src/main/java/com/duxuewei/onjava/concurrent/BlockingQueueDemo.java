package com.duxuewei.onjava.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;

public class BlockingQueueDemo {

    private static ThreadFactory threadFactory =
            new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(5);

        threadFactory.newThread(()->{
            int i=0;
            while (true) {
                try {
                    blockingQueue.put(i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i = 0; i <10; i++) {
            Integer takeInt = blockingQueue.take();
            System.err.println(takeInt);
        }

        System.err.println(blockingQueue);
    }

}
