package com.richard.myapplication4;

public class SkillIqItem {
    private  String mImagaResource;
    private  String mName;
    private  String mPoints;
    private  String mCountry;

    public  SkillIqItem(String imagaResource, String name, String points, String country){
        mImagaResource = imagaResource;
        mName = name;
        mPoints = points;
        mCountry = country;

    }

    public SkillIqItem() {

    }

    public String getImagaResource() {
        return mImagaResource;
    }

    public void setImagaResource(String imagaResource) {
        mImagaResource = imagaResource;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPoints() {
        return mPoints;
    }

    public void setPoints(String points) {
        mPoints = points;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

}
