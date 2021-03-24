package com.duxuewei.onjava.string;

interface Runed {
    void run();
}

public class StringNull {

    private void say () {
        System.err.println("hello");
    }

    public static void main(String[] args) {
        /// System.err.println(StrUtil.utf8Str("知道"));

        // StringNull sss = new StringNull();
        // sss.say();

        Runed r = ()->System.err.println("122");

    }

}
