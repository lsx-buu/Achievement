package com.hqu.achievement.bean;

public class AchievementBean {
    private String name;
    private String about;
    private boolean locked;
    private int nums;
    private int max;
    private int progress;

    public AchievementBean(String name,String about,boolean locked,int nums,int max,int progress){
        this.progress=progress;
        this.name=name;
        this.about=about;
        this.locked=locked;
        this.nums=nums;
        this.max=max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
