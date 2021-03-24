package com.duxuewei.onjava.map.hashmap;

import java.util.HashMap;

/**
 * [hashmap的初始化大小]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-08-17, 周一, 8:17]
 * @Version: [v1.0.0]
 */
public class HashMapSize1 {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        HashMap<String,Object> map  = new HashMap<>(17);
        System.err.println(Integer.toBinaryString(129));
        System.err.println(Integer.toBinaryString(tableSizeFor(129)));
        System.err.println(tableSizeFor(129));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
