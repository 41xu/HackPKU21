package com.jimo.vo;

import com.jimo.model.CategoryLevelOneEnum;

import java.util.List;

/**
 * 用户的Canteen Wikipedia
 * 上传菜品
 * @author algorithm
 */
public class InsertDishesDetailRequest {
    /**
     * 菜品名称 todo 怎么办，用户并不知道菜名是啥
     */
    String name;
    /**
     * 一级类目枚举 todo UI要改
     * @see CategoryLevelOneEnum
     */
    String category;
    /**
     * 食堂位置 todo 是不是唯一标识..多个窗口一道菜
     * @see com.jimo.model.CanteenEnum
     */
    String canteen;
    /**
     * 价格 可能会变...
     * todo 用户上传
     */
    Integer price;

    /**
     * 口味 todo 用户上传
     * @see com.jimo.model.FlavorEnum
     */
    List<String> flavors;
    /**
     * 配料
     * todo 用户上传
     */
    List<String> ingredients;
    /**
     * 热量
     * todo 用户上传
     */
    Integer calorie;
}

