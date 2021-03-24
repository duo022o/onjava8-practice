package com.duxuewei.onjava.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 对list进行自然排序测试
 */
public class ListSort {

    public static void main(String[] args) {
        List<ListSortPojo> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            ListSortPojo pojo = new ListSortPojo();
            //pojo.setId(i);
            pojo.setDes(String.valueOf(11-i));
            list.add(pojo);
        }
        list.stream().sorted();
        System.err.println(list);
    }

}
