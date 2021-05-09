package com.jimo.mapper;

import com.jimo.model.Dish;
import com.jimo.model.DishExample;
import java.util.List;

public interface DishMapper {
    int insert(Dish record);

    int insertSelective(Dish record);

    List<Dish> selectByExample(DishExample example);
}