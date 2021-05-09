package com.jimo.mapper;

import com.jimo.model.DishPicture;
import com.jimo.model.DishPictureExample;
import java.util.List;
import org.apache.ibatis.session.RowBounds;

public interface DishPictureMapper {
    int insert(DishPicture record);

    int insertSelective(DishPicture record);

    List<DishPicture> selectByExampleWithRowbounds(DishPictureExample example, RowBounds rowBounds);

    List<DishPicture> selectByExample(DishPictureExample example);
}