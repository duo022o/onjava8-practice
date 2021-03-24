package com.duxuewei.onjava.lambda;

import cn.hutool.core.io.LineHandler;
import cn.hutool.core.lang.func.VoidFunc1;

import java.util.function.Function;

public class DoubleColonDemo {

    public static void main(String[] args) {

        // Runnable per = Persion::say;

        // Runnable per = new Runnable() {
        //     @Override
        //     public void run() {
        //         Persion.say();
        //     }
        // };

        // Runnable per2 = () -> Persion.say();

        // Runnable per3 = Persion::say;

        // per2.run();


        // VoidFunc1<Persion> say2 = Persion::say2;


        // say2.call(new Persion());

        Persion p = new Persion();
        Persion.a = "你好";
        String a = Persion.a;
        System.err.println(a);

        String a1 = Persion.a;
        System.err.println(a1);
    }


}

class Persion {
    static String a = "2";
}

class P1 extends Persion {
    String b = "6";
}

class P2 extends Persion {
    String c = "6";
}

class DDDD {

    public static void main(String[] args) {
        Persion pp = new P1();
        P2 p2 = (P2) pp;
    }
    
}