package com.jimo.vo;

import com.jimo.model.dishes.DishesItem;

import java.util.List;

/**
 * @author algorithm
 */
public class QueryDishesItemResponse {
    List<DishesItem> dishesItemList;

    public List<DishesItem> getDishesItemList() {
        return dishesItemList;
    }

    public void setDishesItemList(List<DishesItem> dishesItemList) {
        this.dishesItemList = dishesItemList;
    }
}
