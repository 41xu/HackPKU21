package com.jimo.controller;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jimo.mapper.ReviewMapper;
import com.jimo.model.Review;
import com.jimo.model.common.Result;
import com.jimo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author algorithm
 */
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private ReviewMapper reviewMapper;

    @PostMapping("/existing")
    public Result postExistingDishReview(@RequestBody PostExistingDishRequest request){
        // 新增到Review
        Review review = new Review();
        review.setDishId(request.getDishId());
        review.setUserId(request.getUserId());
        review.setDescription(request.getDescription());
        review.setRate(request.getRate());
        review.setFlavor(request.getFlavor());
        review.setWaitTime(request.getWaitTime());
        review.setPrice(request.getPrice());
        // review Id from
        int res = reviewMapper.insert(review);
        System.out.println("review mapper insert result: " + res);
        return new Result(201, "",new PostExistingDishResponse());
    }

    @PostMapping("/new")
    public Result postNewDishReview(@RequestBody PostNewDishRequest request){
        // 新增到Review 和 Dish
        return new Result(201, "", new PostNewDishResponse());
    }


}
