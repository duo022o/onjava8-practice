package com.duxuewei.onjava.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamMatch {

    @Test
    public void anyMatchTest() {
        List<Boolean> booleans = Arrays.asList(true, true, false, true);

        boolean b = booleans.stream()
                .peek(System.out::println)
                .anyMatch(e -> e);
        System.out.println("b:"+b);
        boolean c = booleans.stream()
                .peek(System.out::println)
                .noneMatch(e -> e);
        System.out.println("c:"+c);

    }

}
