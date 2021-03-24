package com.duxuewei.onjava.map.hashmap;

import java.util.HashMap;

/**
 * [如果负载因子为1，当容量存满时，在进行赋值测试]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-08-17, 周一, 8:17]
 * @Version: [v1.0.0]
 */
public class HashMapSize2 {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        HashMap<Object,Object> map  = new HashMap<>(2,1);
        System.err.println(map.size());
        map.put("1",1);
        System.err.println(map.size());
        map.put(49,2);

    }

}
