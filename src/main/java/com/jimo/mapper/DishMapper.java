package com.jimo.mapper;

import com.jimo.model.Dish;
import com.jimo.model.DishExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface DishMapper {
    int insert(Dish record);

    int insertSelective(Dish record);

    List<Dish> selectByExampleWithRowbounds(DishExample example, RowBounds rowBounds);

    List<Dish> selectByExample(DishExample example);
}