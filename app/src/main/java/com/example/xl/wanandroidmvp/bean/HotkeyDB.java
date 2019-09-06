package com.example.xl.wanandroidmvp.bean;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class HotkeyDB extends LitePalSupport{
    private long id;
    @Column(unique = true,defaultValue = "null")
    private String key;
    private int time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
