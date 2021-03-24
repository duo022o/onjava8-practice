package com.duxuewei.onjava.map.hashmap;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * [hashmap的初始化大小]
 * @Author: [Du Xue wei]
 * @CreateDate: [2020-08-17, 周一, 8:17]
 * @Version: [v1.0.0]
 */
public class HashMapLink {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        HashMap<Object,Object> map  = new HashMap<>(1,1);
        System.err.println(map.size());
        map.put("1",1);
        System.err.println(map.size());
        map.put(new Long(49),2);
        map.put(new Integer(49),3);

        try {
            Class<?> hashMapCls = Class.forName("java.util.HashMap");
            Class<?> hashMap$NodeCls = Class.forName("java.util.HashMap$Node");
            Field table = hashMapCls.getDeclaredField("table");
            table.setAccessible(true);
            Object[] arrs = (Object[]) table.get(map);

            Field[] fNodes = hashMap$NodeCls.getDeclaredFields();
            AccessibleObject.setAccessible(fNodes,true);
            Field fNode$next = null;
            Field fNode$key = null;
            for (int i = 0; i < fNodes.length; i++) {
                System.err.println(fNodes[i].getName());
                if ("next".equals(fNodes[i].getName())) {
                    fNode$next = fNodes[i];
                }
                if ("key".equals(fNodes[i].getName())) {
                    fNode$key = fNodes[i];
                }
            }

            for (Object o:arrs) {
                if (o != null) {
                    // Object e = clsHashMap$Node..newInstance();
                    Object o1 = fNode$next.get(o);
                    Object o2 = fNode$next.get(o1);
                    System.err.println(String.format("o = %s, o1 = %s, o2 = %s",o,o1,o2));
                    while ((o = fNode$next.get(o)) != null) {
                        System.err.println(o);
                    }
                }
            }

        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
