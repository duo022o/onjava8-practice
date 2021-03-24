package com.duxuewei.onjava.trans.user;

import java.io.Serializable;

public class OperateModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String Id;
    private String Code;
    private String Name;
    private String TargetId;
    private int SortOrder;
    private boolean Enabled;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTargetId() {
        return TargetId;
    }

    public void setTargetId(String targetId) {
        TargetId = targetId;
    }

    public int getSortOrder() {
        return SortOrder;
    }

    public void setSortOrder(int sortOrder) {
        SortOrder = sortOrder;
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setEnabled(boolean enabled) {
        Enabled = enabled;
    }

}