package com.jimo.vo.entity;

/**
 * 商品列表 View Object
 * @author algorithm
 */
public class DishesItem {
    /**
     * 菜品id
     */
    String dishId;


    /**
     * 商品名称
     */
    String name;
    /**
     * 单位 分
     */
    Integer price;
    /**
     * 食堂 todo enum
     */
    String canteen;

    /**
     * kcal/份
     */
    Integer calorie;

    /**
     * 评分 [0-5]
     */
    Integer rate;

    /**
     * 多少人评分
     */
    Integer rateNumber;

    /**
     * 分钟
     */
    Integer waitTime;

    /**
     * 图片链接 todo 展示的列表只有一张图，单四insert会有很多dishId-pictireId的记录；展示同一id的这张图随机选择？
     */
    String pictureUrl;

    public Integer getRateNumber() {
        return rateNumber;
    }

    public void setRateNumber(Integer rateNumber) {
        this.rateNumber = rateNumber;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCanteen() {
        return canteen;
    }

    public void setCanteen(String canteen) {
        this.canteen = canteen;
    }

    public Integer getCalorie() {
        return calorie;
    }

    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
