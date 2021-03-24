package com.duxuewei.onjava.map;

import java.util.Hashtable;

public class TableDemo {

    public static void main(String[] args) {
        Hashtable<Integer,Integer> table = new Hashtable<>(10);
        table.put(1,1);
        table.put(1,2);
        table.put(1,3);
    }

}
