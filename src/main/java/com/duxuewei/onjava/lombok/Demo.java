package com.duxuewei.onjava.lombok;

import java.util.HashSet;
import java.util.Set;

public class Demo {

    public static void main(String[] args) {

        IntaskDetailExcel detail = new IntaskDetailExcel();
        detail.setCode("1");
        detail.setName("1");
        detail.setCause("0");
        IntaskDetailExcel detail1 = new IntaskDetailExcel();
        detail1.setCode("1");
        detail1.setName("2");
        detail1.setCause("1");
        System.err.println(detail.equals(detail1));
        Set set = new HashSet();
        set.add(detail);
        set.add(detail1);
        System.err.println(set);
        System.err.println(set.size());
    }

}
