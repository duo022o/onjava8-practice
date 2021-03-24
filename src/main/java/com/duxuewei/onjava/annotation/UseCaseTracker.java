package com.duxuewei.onjava.annotation;

// annotations/UseCaseTracker.java

import java.util.*;
import java.util.stream.*;
import java.lang.reflect.*;

/**
 * [UseCase注解处理器]
 *
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-07-8, 周三, 16:8]
 * @Version: [v1.0.0]
 */
public class UseCaseTracker {
    public static void
    trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case " +
                        uc.id() + " -> " + uc.description());
                useCases.remove(Integer.valueOf(uc.id()));
            }
        }
        useCases.forEach(i ->
                System.out.println("Missing use case " + i));
    }

    public static void main(String[] args) {
        List<Integer> useCases = IntStream.range(47, 51)
                .boxed().collect(Collectors.toList());
        trackUseCases(useCases, PasswordUtils.class);
    }
}
