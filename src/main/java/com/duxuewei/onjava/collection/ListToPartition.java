package com.duxuewei.onjava.collection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @apiNote list拆分为多个list
 * @since 2021/1/28 14:04
 * @author Duxuewei
 * @version v1.0.0
 */
public class ListToPartition {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.format("param::{%d}",i));
        }

        List<List<String>> partition = Lists.partition(list,3);

        // 错误！Partition对象只是继承了部分方法
        // partition.add(Arrays.asList("1","2","3"));

        System.err.println(partition);

    }

}
