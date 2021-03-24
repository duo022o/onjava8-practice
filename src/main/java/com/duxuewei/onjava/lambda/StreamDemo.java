package com.duxuewei.onjava.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;


/**
 * [流式开发]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-04-26, 周日, 12:39]
 * @Version: [v1.0.0]
 */
public class StreamDemo {

    public static void main(String[] args) {

        String s = null;
        switch (s) {
            case "s":
                System.err.println(0);
                break;
            case "String":
                System.err.println(1);
                break;
            case "null":
                System.err.println(2);
                break;
            default:
                System.err.println(3);
        }

        /*long l = countRunTime(10);
        long l1 = countRunTimeByLambda(10);
        long l2 = countRunTimeByLambdapall(10);

        System.err.println("1: "+l);
        System.err.println("2: "+l1);
        System.err.println("3: "+l2);*/
    }

    public static long countRunTime(long num) {
        long startTime=System.nanoTime();
        //测试的代码段
        long sum = 0L;
        for (long i = 0; i < num; i++) {
            sum+=1;
        }
        System.err.println(sum);
        long endTime=System.nanoTime();
        System.out.println("1程序运行时间： "+(endTime-startTime));


        return endTime-startTime;
    }

    public static long countRunTimeByLambda(long num) {
        long startTime=System.nanoTime();
        //测试的代码段
        long sum = Stream.of(num).mapToLong(i->i).sum();
        System.err.println(sum);
        long endTime=System.nanoTime();
        System.out.println("2程序运行时间： "+(endTime-startTime));


        return endTime-startTime;
    }

    public static long countRunTimeByLambdapall(long num) {
        long startTime=System.nanoTime();
        //测试的代码段
        long sum = Stream.of(num).parallel().mapToLong(i->i).sum();
        System.err.println(sum);
        long endTime=System.nanoTime();
        System.out.println("3程序运行时间： "+(endTime-startTime));


        return endTime-startTime;
    }

    public static void console(String str){
        System.out.println("str = " + str+ " || ");
    }

    /**
     * 实用循环方法
     * @param n
     * @param action
     */
    public static void repeat(int n, Runnable action) {
        range(0, n).forEach(i -> action.run());
    }

}
