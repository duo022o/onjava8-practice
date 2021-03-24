package com.duxuewei.onjava.lambda;

import com.duxuewei.onjava.pojo.Person;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaToMap {

    public static void main(String[] args) {



        /*List<Person> personList = packPersions();
        Map<Object, Object> perMap = personList.stream()
                .map(e -> new ToMap(e.getName(), e))
                .collect(Collectors.toMap(ToMap::getKey, ToMap::getValue));
        perMap.entrySet().forEach(en->{
            System.err.println(en);
        });*/
    }

    private static int[] rints = new Random(47)
            .ints(0, 1000).limit(100).toArray();

    private static List<Person> packPersions() {
        List<Person> perList = Arrays.stream(rints).limit(10)
                .mapToObj(e -> new Person("name" + e, e, new Date()))
                .collect(Collectors.toList());
        return perList;
    }

}

class ToMap<R,T> {
    private R key;
    private T value;

    public ToMap() {
    }

    public ToMap(R key, T value) {
        this.key = key;
        this.value = value;
    }

    public R getKey() {
        return key;
    }

    public void setKey(R key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
