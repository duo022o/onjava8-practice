package com.duxuewei.onjava.comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @apiNote 比较器测试
 * @since 2021/2/1 15:34
 * @author Duxuewei
 * @version v1.0.0
 */
public class ComparatorDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(6);
        list.add(2);
        System.err.println(list);

        // List<Integer> newlist = list.stream()
        //         .sorted((pre, old) -> (pre < old) ? 0 : -1)
        //         .collect(Collectors.toList());
        list.sort((now,old)-> (now > old) ? 0 : -1);
        System.err.println(list);
        // System.err.println(newlist);

    }

}
