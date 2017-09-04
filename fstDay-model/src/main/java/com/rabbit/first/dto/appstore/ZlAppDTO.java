package com.rabbit.first.dto.appstore;

/**
 * Created by Mr.Rabbit on 2017/6/22.
 */
public class ZlAppDTO {
    private int id;
    private String title;
    private String packageName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
