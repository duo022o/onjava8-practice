
package com.duxuewei.onjava.json;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class Entity2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String pid;
    private String n;
    private List<Entity2> s;

}
