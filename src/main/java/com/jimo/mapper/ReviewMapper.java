package com.jimo.mapper;

import com.jimo.model.Review;
import com.jimo.model.ReviewExample;
import java.util.List;

public interface ReviewMapper {
    int insert(Review record);

    int insertSelective(Review record);

    List<Review> selectByExample(ReviewExample example);
}