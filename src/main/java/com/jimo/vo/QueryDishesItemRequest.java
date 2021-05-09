package com.jimo.vo;

import com.jimo.model.CategoryLevelOneEnum;

import java.util.List;

/**
 * @author algorithm
 */
public class QueryDishesItemRequest {
    /**
     * 菜品名称 todo 怎么办
     */
    String name;
    /**
     * 一级类目枚举 todo 不全
     * @see CategoryLevelOneEnum
     */
    String category;
    /**
     * 食堂位置 todo 是不是唯一标识？
     * @see com.jimo.model.CanteenEnum
     */
    String canteen;
    /**
     * 价格 todo 可能会变，最后展示什么呢, 这个数据数入要不要权威的食堂来定
     */
    Integer price;

    /**
     * 口味 todo 学生来定
     * @see com.jimo.model.FlavorEnum
     */
    List<String> flavors;
    /**
     * 配料 todo 学生来定 or 食堂来定
     */
    List<String> ingredients;
    /**
     * 最大卡路里数 todo 可添加身体数据，辅助计算
     */
    Integer maxCalorie;
    /**
     * 分钟
     */
    Integer waitTime;

    /**
     * 从1开始，default 1 pageSize = 10
     */
    Integer page = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCanteen() {
        return canteen;
    }

    public void setCanteen(String canteen) {
        this.canteen = canteen;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<String> getFlavors() {
        return flavors;
    }

    public void setFlavors(List<String> flavors) {
        this.flavors = flavors;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getMaxCalorie() {
        return maxCalorie;
    }

    public void setMaxCalorie(Integer maxCalorie) {
        this.maxCalorie = maxCalorie;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }

    public QueryDishesItemRequest(String name, String category, String canteen, Integer price, List<String> flavors, List<String> ingredients, Integer maxCalorie, Integer waitTime, Integer page) {
        this.name = name;
        this.category = category;
        this.canteen = canteen;
        this.price = price;
        this.flavors = flavors;
        this.ingredients = ingredients;
        this.maxCalorie = maxCalorie;
        this.waitTime = waitTime;
        this.page = page;
    }
}
