package com.duxuewei.onjava.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @apiNote 并发Map
 * @since 2021/3/1 15:44
 * @author Duxuewei
 * @version v1.0.0
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(10);

        concurrentHashMap.put("a",1);

        Object a = concurrentHashMap.get("a");

        System.err.println(a);
    }

}
