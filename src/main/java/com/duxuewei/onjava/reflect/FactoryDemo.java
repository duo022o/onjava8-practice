package com.duxuewei.onjava.reflect;

import com.duxuewei.onjava.pojo.Person;

public class FactoryDemo {

    public static void main(String[] args) {

        try {

            Class cls = Class.forName("com.duxuewei.onjava.pojo.Person");

            Person person = (Person) cls.newInstance();
            System.err.println(person);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("123");
        }


    }

}
