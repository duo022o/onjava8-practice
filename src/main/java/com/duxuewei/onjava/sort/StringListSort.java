package com.duxuewei.onjava.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 对list进行自然排序测试
 */
public class StringListSort {
    private static List<ListSortPojo> list;
    static {
        list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            ListSortPojo pojo = new ListSortPojo();
            //pojo.setId(i);
            pojo.setDes(UUID.randomUUID().toString());
            pojo.setInfo(UUID.randomUUID().toString());
            list.add(pojo);
        }
    }
    public static void main(String[] args) {
        System.err.println(list);
        list.sort((a,b)->{
            System.err.println(a.getDes().compareTo(b.getDes()));
            return a.getDes().compareTo(b.getDes())>0?0:-1;
        });
        System.err.println(list);
    }

}
