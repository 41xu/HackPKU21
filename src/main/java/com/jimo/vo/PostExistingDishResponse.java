package com.jimo.vo;

/**
 * @author algorithm
 */
public class PostExistingDishResponse {
    /**
     * 已经存在的菜品id
     */
    String dishId;

    public PostExistingDishResponse(String dishId) {
        this.dishId = dishId;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }
}
