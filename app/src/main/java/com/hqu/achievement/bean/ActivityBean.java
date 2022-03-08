package com.hqu.achievement.bean;

import android.graphics.drawable.Drawable;

public class ActivityBean {
    private Drawable bacbground;
    private String title;

    public ActivityBean(Drawable bacbground,String title){
        this.bacbground=bacbground;
        this.title=title;
    }

    public Drawable getBacbground() {
        return bacbground;
    }

    public void setBacbground(Drawable bacbground) {
        this.bacbground = bacbground;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
