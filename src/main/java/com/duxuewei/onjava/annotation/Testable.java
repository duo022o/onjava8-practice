package com.duxuewei.onjava.annotation;

import org.junit.Test;

public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }
    @Test
    public void testExecute() { execute(); }
}
