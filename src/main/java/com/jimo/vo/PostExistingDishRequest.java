package com.jimo.vo;

import java.util.List;

/**
 * @author algorithm
 */
public class PostExistingDishRequest {
    /**
     * 菜品的distinct id
     */
    Integer dish_id;
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
}
