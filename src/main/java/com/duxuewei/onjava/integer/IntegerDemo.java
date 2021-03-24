package com.duxuewei.onjava.integer;

import org.junit.Test;

/**
 * [整形测试]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-07-27, 周一, 14:16]
 * @Version: [v1.0.0]
 */
public class IntegerDemo {

    @Test
    public void countIntegerTest() {
        Integer i = 1,n;
        System.err.println(i!=null?++i:1);
    }

    public static void main(String[] args) {
        Integer i = 1;
        Short n = 1;
        Short m = null;
        System.err.println(i.equals(m.intValue()));
    }

}
