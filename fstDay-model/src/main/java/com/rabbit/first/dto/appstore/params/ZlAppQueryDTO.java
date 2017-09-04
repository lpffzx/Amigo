package com.rabbit.first.dto.appstore.params;

/**
 * Created by Mr.Rabbit on 2017/6/22.
 */
public class ZlAppQueryDTO {
    /**
     * 应用id
     */
    private int id;

    /**
     * 应用包名
     */
    private String packageName;

    public ZlAppQueryDTO(int id, String packageName) {
        this.id = id;
        this.packageName = packageName;
    }

    public ZlAppQueryDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
