package com.jimo.vo;

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
     * 一级类目
     * @see com.jimo.model.CategoryLevelOneEnum
     */
    String category;

    /**
     * 食堂
     * @see com.jimo.model.CanteenEnum
     */
    String canteen;
}
