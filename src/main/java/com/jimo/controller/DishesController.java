package com.jimo.controller;

import com.google.common.base.Strings;
import com.jimo.mapper.DishMapper;
import com.jimo.mapper.DishPictureMapper;
import com.jimo.mapper.ReviewMapper;
import com.jimo.model.*;
import com.jimo.model.common.Result;
import com.jimo.model.enums.CanteenEnum;
import com.jimo.utils.EnumUtils;
import com.jimo.utils.MyConsts;
import com.jimo.vo.entity.DishesItem;
import com.jimo.vo.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author algorithm
 */
@RestController
@RequestMapping("/dishes")
public class DishesController {

    @Autowired
    ReviewMapper reviewMapper;

    @Autowired
    DishMapper dishMapper;

    @Autowired
    DishPictureMapper dishPictureMapper;

    @GetMapping("/getOne")
    public Result getOne(@RequestParam(value = "dishId", required = true) String dishId) {
        DishExample example = new DishExample();
        example.createCriteria().andDishIdEqualTo(dishId);
        List<Dish> dishList = dishMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(dishList)) {
            return new Result(500, "invalid dishId");
        }
        Dish dish = dishList.get(0);

        DishesItem dishesItem = new DishesItem();
        dishesItem.setDishId(dish.getDishId());
        dishesItem.setCanteen(dish.getCanteen());
        dishesItem.setCalorie(dish.getCalories());
        dishesItem.setName(dish.getDishName());
        dishesItem.setPrice(dish.getPrice());
        dishesItem.setFlavor(dish.getFlavor());
        ReviewExample reviewExample = new ReviewExample();
        reviewExample.createCriteria().andDishIdEqualTo(dish.getDishId());
        List<Review> reviewList = reviewMapper.selectByExample(reviewExample);
        double totWaitTime = 0;
        double totRate = 0;
        double cntWaitTime = 0;
        double cntRate = 0;
        for (Review review : reviewList) {
            if (review.getWaitTime() != null) {
                totWaitTime += review.getWaitTime();
                cntWaitTime += 1.0;
            }
            if (review.getRate() != null) {
                totRate += review.getRate();
                cntRate += 1.0;
            }
        }
        // todo 处理没有评论的情况 review db
        if (cntWaitTime > 0) {
            dishesItem.setWaitTime((int) Math.floor(totWaitTime / cntWaitTime));
        } else {
            dishesItem.setWaitTime(0);
        }
        if (cntRate > 0) {
            // todo cal review avg rate
            dishesItem.setRate((int) Math.floor(totRate / cntRate));
        } else {
            dishesItem.setRate(0);
        }
        dishesItem.setRateNumber((int) Math.floor(cntRate));
        DishPictureExample dishPictureExample = new DishPictureExample();
        dishPictureExample.createCriteria().andDishIdEqualTo(dish.getDishId());
        List<DishPicture> dp = dishPictureMapper.selectByExample(dishPictureExample);
        if (!CollectionUtils.isEmpty(dp)) {
            dishesItem.setPictureUrl(dp.get(0).getPictureUrl());
        } else {
            dishesItem.setPictureUrl("https://z3.ax1x.com/2021/05/10/gYxy8I.jpg");
        }


        return new Result(200, "", dishesItem);
    }

    @GetMapping("/getList")
    public Result getDishesList(@RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "category", required = false) String category,
                                @RequestParam(value = "canteen", required = false) String canteen,
                                @RequestParam(value = "minPrice", required = false) Integer minPrice,
                                @RequestParam(value = "maxPrice", required = false) Integer maxPrice,
                                @RequestParam(value = "ingredients", required = false) List<String> ingredients,
                                @RequestParam(value = "maxCalorie", required = false) Integer maxCalorie,
                                @RequestParam(value = "page", required = false) Integer page) {

        DishExample example = new DishExample();
        DishExample.Criteria criteria = example.createCriteria();
        if (!Strings.isNullOrEmpty(name)) {
            System.out.println(name);
            criteria.andDishNameLike("%" + name + "%");
        }
        if (!Strings.isNullOrEmpty(category)) {
            criteria.andCategoryEqualTo(category);
        }
        if (!Strings.isNullOrEmpty(category)) {
            criteria.andCategoryEqualTo(category);
        }
        if (minPrice != null && minPrice > 0 && maxPrice != null && maxPrice > 0) {
            criteria.andPriceBetween(minPrice, maxPrice);
        }
        if (maxCalorie != null) {
            criteria.andCaloriesLessThan(maxCalorie);
        }
        if (!CollectionUtils.isEmpty(ingredients)) {
            criteria.andIndegrentIn(ingredients);
        }
        if (!Strings.isNullOrEmpty(canteen) && EnumUtils.isValidEnum(CanteenEnum.class, canteen)) {
            criteria.andCanteenEqualTo(canteen);
        }
        // todo 以下是返回值todo
        // todo 增加平均评分，从review查询同一个dishId
        // todo pictureUrl 从新的库表查询
        // todo 平均等餐时间 从review查询同一个dishId
        int offset = (page == null) ? 0 : (page - MyConsts.DEFAULT_PAGE_BEGIN) * MyConsts.DEFAULT_PAGE_SIZE;
        RowBounds rowBounds = new RowBounds(offset, MyConsts.DEFAULT_PAGE_SIZE);
        List<Dish> dishList = dishMapper.selectByExampleWithRowbounds(example, rowBounds);
        List<DishesItem> retList = new ArrayList<>();
        for (Dish dish : dishList) {

            DishesItem dishesItem = new DishesItem();
            dishesItem.setDishId(dish.getDishId());
            dishesItem.setCanteen(dish.getCanteen());
            dishesItem.setCalorie(dish.getCalories());
            dishesItem.setName(dish.getDishName());
            dishesItem.setPrice(dish.getPrice());
            dishesItem.setFlavor(dish.getFlavor());
            ReviewExample reviewExample = new ReviewExample();
            reviewExample.createCriteria().andDishIdEqualTo(dish.getDishId());
            List<Review> reviewList = reviewMapper.selectByExample(reviewExample);
            double totWaitTime = 0;
            double totRate = 0;
            double cntWaitTime = 0;
            double cntRate = 0;
            for (Review review : reviewList) {
                if (review.getWaitTime() != null) {
                    totWaitTime += review.getWaitTime();
                    cntWaitTime += 1.0;
                }
                if (review.getRate() != null) {
                    totRate += review.getRate();
                    cntRate += 1.0;
                }
            }
            // todo 处理没有评论的情况 review db
            if (cntWaitTime > 0) {
                dishesItem.setWaitTime((int) Math.floor(totWaitTime / cntWaitTime));
            } else {
                dishesItem.setWaitTime(0);
            }
            if (cntRate > 0) {
                // todo cal review avg rate
                dishesItem.setRate((int) Math.floor(totRate / cntRate));
            } else {
                dishesItem.setRate(0);
            }
            dishesItem.setRateNumber((int) Math.floor(cntRate));
            DishPictureExample dishPictureExample = new DishPictureExample();
            dishPictureExample.createCriteria().andDishIdEqualTo(dish.getDishId());
            List<DishPicture> dp = dishPictureMapper.selectByExample(dishPictureExample);
            if (!CollectionUtils.isEmpty(dp)) {
                dishesItem.setPictureUrl(dp.get(0).getPictureUrl());
            } else {
                dishesItem.setPictureUrl("https://z3.ax1x.com/2021/05/10/gYxy8I.jpg");
            }
            retList.add(dishesItem);
        }
        return new Result(200, "", retList);

    }


}
