package com.duxuewei.onjava.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * [简单Java类]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-08-17, 周一, 13:18]
 * @Version: [v1.0.0]
 */
@Data
@AllArgsConstructor
public class Person implements Cloneable{

    public Person() {
        System.err.println("person无参构造");
    }

    private String name;
    private Integer age;
    private Date birthday;

}
