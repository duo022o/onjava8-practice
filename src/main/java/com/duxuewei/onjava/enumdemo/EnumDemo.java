package com.duxuewei.onjava.enumdemo;

/**
 * [枚举类型]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-06-9, 周二, 9:36]
 * @Version: [v1.0.0]
 */
public enum EnumDemo {
    male(1),
    female(2);
    private final int sex;
    EnumDemo(int sex) {
        this.sex = sex;
    }
    public static void printSex(int i) {
        switch(i) {
            case 1:
                System.out.println(EnumDemo.male);
                break;
            case 2:
                System.out.println(EnumDemo.female);
                break;
            default:
                System.out.println("wrong number!");
        }
    }
    public int getSex() {
        return sex;
    }
}
