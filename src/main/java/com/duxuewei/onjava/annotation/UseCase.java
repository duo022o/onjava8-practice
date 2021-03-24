package com.duxuewei.onjava.annotation;

// annotations/UseCase.java
import java.lang.annotation.*;

/**
 * [id]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-07-8, 周三, 16:2]
 * @Version: [v1.0.0]
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    int id();
    String description() default "no description";
}
