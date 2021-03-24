package com.duxuewei.onjava.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

    public static void main(String[] args) {
        /// List a = null;
        /// a.get(0);
        /// a.size();
        /* Object str = "存管号*1";
        boolean flg = Arrays.asList("存管号", "存管号*").contains(str);
        System.err.println(flg);*/
        /** 测试List转数组的时候数组大小的问题 */
        /// List<String> list = new ArrayList<>(2);
        /// list.add("zhangsan");
        /// list.add("lisi");
///
        /// String[] strings = new String[list.size()+1];
        /// System.err.println(strings);
        /// list.toArray(strings);
        /// System.err.println(strings);
        /// System.err.println(Arrays.toString(strings));
        /** 测试Arrays.asList()的异常情况 */
        String[] strings = new String[]{"张三","李四"};
        List<String> arrList = Arrays.asList(strings);
        arrList.add("王五");
    }

}
