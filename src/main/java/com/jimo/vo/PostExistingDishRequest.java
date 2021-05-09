package com.jimo.vo;

import java.util.List;

/**
 * @author algorithm
 */
public class PostExistingDishRequest {
    /**
     * 菜品的distinct id
     */
    Integer dishId;
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
     * @see com.jimo.model.FlavorEnum
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
     * 微信名
     */
    String userId;

    public PostExistingDishRequest(Integer dishId, String description, List<String> pictureUrls, Integer rate, List<String> flavor, Integer waitTime, Integer price, String userId) {
        this.dishId = dishId;
        this.description = description;
        this.pictureUrls = pictureUrls;
        this.rate = rate;
        this.flavor = flavor;
        this.waitTime = waitTime;
        this.price = price;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
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

}
