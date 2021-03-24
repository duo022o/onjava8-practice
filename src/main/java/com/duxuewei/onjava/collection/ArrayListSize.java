package com.duxuewei.onjava.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSize {

    public static void main(String[] args) {
        List li = new ArrayList(1);
        System.err.println(li.size());
        li.add(new Object());
        System.err.println(li.size());
    }

}
