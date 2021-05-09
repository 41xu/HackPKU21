package com.jimo.vo.entity;

import java.util.List;

/**
 * 商品详情 View Object
 * @author algorithm
 */
public class ReviewItem {
    String Id;
    /**
     * ISO格式
     */
    String time;
    Integer rate;
    String description;
    /**
     * @see com.jimo.model.enums.FlavorEnum
     */
    String flavor;
    /**
     * 单位分钟
     */
    Integer waitTime;
    /**
     * 价格 单位分
     */
    Integer price;
    /**
     * 一级类目
     * @see com.jimo.model.enums.CategoryLevelOneEnum
     */
    String category;

    /**
     * 图片链接
     */
    List<String> pictureUrls;

    String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
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

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }
}
