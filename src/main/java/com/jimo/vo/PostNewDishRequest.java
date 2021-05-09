package com.jimo.vo;

import com.jimo.model.enums.CanteenEnum;
import com.jimo.model.enums.CategoryLevelOneEnum;
import com.jimo.model.enums.FlavorEnum;

import java.util.List;

/**
 * @author algorithm
 */
public class PostNewDishRequest {
    /**
     * 描述
     */
    String description;
    /**
     * 图片
     */
    List<String> pictureUrls;

    Integer rate;
    /**
     * 口味
     * @see FlavorEnum
     */
    List<String> flavor;
    /**
     * 等待时间
     */
    Integer waitTime;
    /**
     * 单位 分
     */
    Integer price;

    /**
     * 可选添加名字
     */
    String name;

    /**
     * 一级类目
     * @see CategoryLevelOneEnum
     */
    String category;

    /**
     * 食堂
     * @see CanteenEnum
     */
    String canteen;

    /**
     * 微信名
     */
    String userId;

    public PostNewDishRequest(String description, List<String> pictureUrls, Integer rate, List<String> flavor, Integer waitTime, Integer price, String category, String canteen, String userId) {
        this.description = description;
        this.pictureUrls = pictureUrls;
        this.rate = rate;
        this.flavor = flavor;
        this.waitTime = waitTime;
        this.price = price;
        this.category = category;
        this.canteen = canteen;
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public List<String> getFlavor() {
        return flavor;
    }

    public void setFlavor(List<String> flavor) {
        this.flavor = flavor;
    }

    public Integer getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
