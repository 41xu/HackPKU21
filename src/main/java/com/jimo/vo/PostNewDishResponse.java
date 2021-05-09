package com.jimo.vo;

/**
 * @author algorithm
 */
public class PostNewDishResponse {
    /**
     * 新增菜品id
     */
    String dishId;

    public PostNewDishResponse(String dishId) {
        this.dishId = dishId;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }
}
