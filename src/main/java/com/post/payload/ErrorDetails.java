package com.post.payload;

import java.util.Date;

public class ErrorDetails {

    private Date date;
    private String msg;
    private String description;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ErrorDetails(Date date, String description, String msg) {
        this.date = date;
        this.description = description;
        this.msg = msg;
    }
}
