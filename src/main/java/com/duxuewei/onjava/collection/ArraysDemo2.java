package com.duxuewei.onjava.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysDemo2 {

    public static void main(String[] args) {
        /*Arrays.asList(1,2,3,4,5,6,7,8,9,0).stream().forEach(i->{
            if(i%3==0) {
                return;
            }
            System.err.println("现在是："+i);
        });*/
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        List<Integer> collect = list.stream().collect(Collectors.toList());
        collect.add(10);
        System.err.println(collect);
        list.add(11);
        System.err.println(list);
    }

}
