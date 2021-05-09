package com.jimo.controller;
import java.util.List;
import java.util.UUID;

import com.jimo.mapper.DishMapper;
import com.jimo.mapper.ReviewMapper;
import com.jimo.model.Dish;
import com.jimo.model.DishExample;
import com.jimo.model.Review;
import com.jimo.model.common.Result;
import com.jimo.vo.*;
import io.jsonwebtoken.lang.Collections;
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

    @Autowired
    private DishMapper dishMapper;

    @PostMapping("/existing")
    public Result postExistingDishReview(@RequestBody PostExistingDishRequest request){
        //  校验是不是存在这个dish
        DishExample dishExample = new DishExample();
        dishExample.createCriteria().andDishIdEqualTo(request.getDishId());
        List<Dish> list = dishMapper.selectByExample(dishExample);
        if(Collections.isEmpty(list)){
            return new Result(500, "错误的dishId");
        }
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
        return new Result(201, "",new PostExistingDishResponse(request.getDishId()));
    }

    @PostMapping("/new")
    public Result postNewDishReview(@RequestBody PostNewDishRequest request){
        // 新增菜品
        String dishUuid = UUID.randomUUID().toString();
        String reviewUuid = UUID.randomUUID().toString();
        Dish dish = new Dish();
        dish.setDishId(dishUuid);
        dish.setDishName(request.getName());
        dish.setSource(request.getUserId()!=null?1:0);
        dish.setCategory(request.getCategory());
        dish.setCanteen(request.getCanteen());

        // dish.setIndegrent(); 商家专用字段
        // dish.setCalories(0); 商家专用字段
        dish.setPrice(request.getPrice());
        dish.setFlavor(request.getFlavor());

        // 新增到新增Review
        Review review = new Review();
        review.setDishId(dishUuid);// 刚才生成uuid
        review.setReviewId(reviewUuid);// 随即s生成uuid
        review.setUserId(request.getUserId());
        review.setDescription(request.getDescription());
        review.setRate(request.getRate());
        review.setFlavor(request.getFlavor());
        review.setWaitTime(request.getWaitTime());
        review.setPrice(request.getPrice());

        return new Result(201, "", new PostNewDishResponse(dishUuid));
    }


}
