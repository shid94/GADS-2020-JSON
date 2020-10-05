package com.richard.myapplication4;

public class LearningItem {
    private  String mImageResource;
    private  String mName;
    private  String mLearningHours;
    private  String mCountry;

    public  LearningItem(String imageResource, String name, String hours, String country){
        this.mLearningHours = hours;
        this.mCountry = country;
        this.mImageResource = imageResource;
        this.mName = name;

    }

    public LearningItem() {

    }

    public String getImageResource() {
        return mImageResource;
    }

    public void setImageResource(String imageResource) {
        mImageResource = imageResource;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getLearningHours() {
        return mLearningHours;
    }

    public void setLearningHours(String learningHours) {
        mLearningHours = learningHours;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }
}

