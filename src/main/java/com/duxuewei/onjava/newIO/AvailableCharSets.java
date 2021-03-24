package com.duxuewei.onjava.newIO;

// newio/AvailableCharSets.java
// (c)2017 MindView LLC: see Copyright.txt
// 我们无法保证该代码是否适用于其他用途。
// 访问 http://OnJava8.com 了解更多本书信息。
// 展示 Charsets 和 aliases
import java.nio.charset.*;
import java.util.*;

public class AvailableCharSets {

    public static void main(String[] args) {
        SortedMap<String,Charset> charSets =
                Charset.availableCharsets();

        for(String csName : charSets.keySet()) {
            System.out.print(csName);
            Iterator aliases = charSets.get(csName)
                    .aliases().iterator();
            if(aliases.hasNext())
                System.out.print(": ");

            while(aliases.hasNext()) {
                System.out.print(aliases.next());
                if(aliases.hasNext())
                    System.out.print(", ");
            }
            System.out.println();
        }
    }
}
