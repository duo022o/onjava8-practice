package com.duxuewei.onjava.trans.user;

import java.io.Serializable;

public class LoginResult extends ResultBase implements Serializable {
    private static final long serialVersionUID = 1L;
    private LoginModel Data;

    public LoginModel getData() {
        return Data;
    }

    public void setData(LoginModel data) {
        this.Data = data;
    }
}