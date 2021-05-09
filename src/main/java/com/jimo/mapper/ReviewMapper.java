package com.jimo.mapper;

import com.jimo.model.Review;
import com.jimo.model.ReviewExample;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface ReviewMapper {
    int insert(Review record);

    int insertSelective(Review record);

    List<Review> selectByExampleWithRowbounds(ReviewExample example, RowBounds rowBounds);

    List<Review> selectByExample(ReviewExample example);
}