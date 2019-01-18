package com.mainserver.careercenter.dto;

public class JobTitle {

    private int id;
    private String title;

    public JobTitle(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
