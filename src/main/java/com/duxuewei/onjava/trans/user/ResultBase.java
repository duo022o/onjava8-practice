package com.duxuewei.onjava.trans.user;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class ResultBase implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean Success;

    private String AllMessages;

    private int Status;

    public boolean isSuccess() {
        this.Success = StringUtils.isBlank(this.AllMessages);
        return this.Success;
    }

    public int getStatus() {
        if (Status > 0) {
            return Status;
        } else {
            return 200;
        }
    }

    public void setStatus(int status) {
        this.Status = status;
    }

    public String getAllMessages() {
        return AllMessages;
    }

    public void setAllMessages(String allMessages) {
        this.AllMessages = allMessages;
        if (StringUtils.isNotBlank(this.AllMessages)) {
            this.Status = 500;
        }
    }

    public void setSuccess(boolean success) {
        this.Success = success;
    }
}