package com.duxuewei.onjava.trans.user;

import java.io.Serializable;

public class AuthRole implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String Id;
    private String Name;

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setId(String id) {
        this.Id = id;
    }
}