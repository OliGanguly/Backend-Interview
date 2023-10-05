package com.example.RestClient.Model;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;

public class TodoResponse implements Serializable {
    private Integer id;

    private Boolean completed;

    private String title;

    private Integer userId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
