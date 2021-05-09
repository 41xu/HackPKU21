package com.jimo.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.jimo.mapper.DishMapper;
import com.jimo.mapper.DishPictureMapper;
import com.jimo.mapper.ReviewMapper;
import com.jimo.model.Dish;
import com.jimo.model.DishExample;
import com.jimo.model.DishPicture;
import com.jimo.model.Review;
import com.jimo.model.common.Result;
import com.jimo.vo.*;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
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

    @Autowired
    private DishPictureMapper dishPictureMapper;

    @PostMapping("/existing")
    public Result postExistingDishReview(@RequestBody PostExistingDishRequest request) {
        //  校验是不是存在这个dish
        DishExample dishExample = new DishExample();
        dishExample.createCriteria().andDishIdEqualTo(request.getDishId());
        List<Dish> list = dishMapper.selectByExample(dishExample);
        if (Collections.isEmpty(list)) {
            return new Result(500, "dishId does not exists");
        }
        // 新增到Review 是一个新的review需要分配uuid
        Review review = new Review();
        String reviewUuid = UUID.randomUUID().toString();
        review.setReviewId(reviewUuid);
        review.setDishId(request.getDishId());
        review.setUserId(request.getUserId());
        review.setDescription(request.getDescription());
        review.setRate(request.getRate());
        review.setFlavor(request.getFlavor());
        review.setWaitTime(request.getWaitTime());
        review.setPrice(request.getPrice());
        // todo 插入时间
        review.setCreateDate(new Timestamp(System.currentTimeMillis()));
        // review Id from
        int res = reviewMapper.insert(review);
        System.out.println("review mapper insert result: " + res);

        // todo 插入picture
        List<String> pictureUrlList = request.getPictureUrls();
        if (!CollectionUtils.isEmpty(pictureUrlList)) {
            for (String url : pictureUrlList) {
                DishPicture dishPicture = new DishPicture();
                dishPicture.setDishId(request.getDishId());
                dishPicture.setPictureUrl(url);
                dishPicture.setReviewId(reviewUuid);
                dishPictureMapper.insert(dishPicture);
            }
        }
        return new Result(201, "", new PostExistingDishResponse(request.getDishId()));
    }

    @PostMapping("/new")
    public Result postNewDishReview(@RequestBody PostNewDishRequest request) {

        // 新增菜品
        String dishUuid = UUID.randomUUID().toString();
        String reviewUuid = UUID.randomUUID().toString();
        Dish dish = new Dish();
        dish.setDishId(dishUuid);
        dish.setDishName(request.getName());
        dish.setSource(request.getUserId() != null ? 1 : 0);
        dish.setCategory(request.getCategory());
        dish.setCanteen(request.getCanteen());

        // dish.setIndegrent(); 商家专用字段
        if(request.getCalorie()!=null){
            dish.setCalories(request.getCalorie());
        } else {
            dish.setCalories(0);
        }
        dish.setPrice(request.getPrice());
        dish.setFlavor(request.getFlavor());
        int res = dishMapper.insert(dish);
        System.out.println("insert dish res: " + res);
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
        // todo 插入时间
        review.setCreateDate(new Timestamp(System.currentTimeMillis()));
        res = reviewMapper.insert(review);
        System.out.println("insert dish res: " + res);

        // todo 插入picture
        List<String> pictureUrlList = request.getPictureUrls();
        for (String url : pictureUrlList) {
            DishPicture dishPicture = new DishPicture();
            dishPicture.setDishId(dishUuid);
            dishPicture.setPictureUrl(url);
            dishPicture.setReviewId(reviewUuid);
            dishPictureMapper.insert(dishPicture);
        }
        return new Result(201, "", new PostNewDishResponse(dishUuid));
    }


}
