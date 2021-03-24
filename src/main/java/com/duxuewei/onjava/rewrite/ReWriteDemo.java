package com.duxuewei.onjava.rewrite;

public class ReWriteDemo {

    public void say() {
        System.err.println("父类：你好");
    }

    public static void main(String[] args) {
        ReWriteDemo demo = new ReWriteTwoDemo();
        demo.say();
    }

}

class ReWriteTwoDemo extends ReWriteDemo {

    @Override
    public void say() {
        System.err.println("子类：你好");
    }

}