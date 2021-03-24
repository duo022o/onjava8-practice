package com.duxuewei.onjava.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * [Map测试]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-07-10, 周五, 16:4]
 * @Version: [v1.0.0]
 */
public class MapDemo {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("key"+i,i);
        }
        Set<String> strings = map.keySet();
        map.put("测试",10);
        System.err.println(strings);
        strings.add("set_add");
        System.err.println(strings);
    }

}

class Demo2 {
    static transient Set<String> strings;
    public static void main(String[] args) {

        strings = new HashSet<>();
        strings.add("1");

    }
}


