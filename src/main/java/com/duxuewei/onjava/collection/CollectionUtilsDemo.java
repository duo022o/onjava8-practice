package com.duxuewei.onjava.collection;

import org.junit.Test;

import java.util.*;
import org.apache.commons.collections.CollectionUtils;

public class CollectionUtilsDemo {

    @Test
    public void disjunctionDemo() {
        List<String> col1 = Arrays.asList("1","2","3","3","21","1","2");
        Set<String> set = new HashSet<>(col1);
        Collection rs = CollectionUtils.disjunction(col1, set);

        System.err.println(rs);
    }

}
