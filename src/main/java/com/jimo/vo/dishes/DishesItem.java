package com.jimo.vo.dishes;

/**
 * 商品列表 View Object
 * @author algorithm
 */
public class DishesItem {
    /**
     * 菜品id
     */
    Integer dishId;


    /**
     * 商品名称
     */
    String name;
    /**
     * 单位 元
     */
    String price;
    /**
     * 食堂 todo enum
     */
    String position;

    /**
     * kcal/份
     */
    Integer calorie;

    /**
     * 评分 [0-5]
     */
    Integer rate;

    /**
     * 分钟
     */
    Integer waitTime;

    /**
     * 多少人评分
     */
    Integer rateNumber;

    /**
     * 图片链接 todo 展示的列表只有一张图，单四insert会有很多dishId-pictireId的记录；展示同一id的这张图随机选择？
     */
    String pictureUrl;

    public DishesItem(String name, String price, String position, Integer calorie, Integer rate, Integer rateNumber, String pictureUrl, Integer waitTime) {
        this.name = name;
        this.price = price;
        this.position = position;
        this.calorie = calorie;
        this.rate = rate;
        this.rateNumber = rateNumber;
        this.pictureUrl = pictureUrl;
        this.waitTime = waitTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public Integer getRateNumber() {
        return rateNumber;
    }

    public void setRateNumber(Integer rateNumber) {
        this.rateNumber = rateNumber;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }
}