package com.jimo.controller;

import com.google.common.base.Strings;
import com.jimo.mapper.DishMapper;
import com.jimo.mapper.ReviewMapper;
import com.jimo.model.DishExample;
import com.jimo.model.common.Result;
import com.jimo.vo.dishes.DishesItem;
import com.jimo.vo.*;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getList")
    public Result getDishesList(@RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "category", required = false) String category,
                                @RequestParam(value = "minPrice", required = false) Integer minPrice,
                                @RequestParam(value = "maxPrice", required = false) Integer maxPrice,
                                @RequestParam(value = "flavors", required = false) List<String> flavors,
                                @RequestParam(value = "ingredients", required = false) List<String> ingredients,
                                @RequestParam(value = "maxCalorie", required = false) Integer maxCalorie,
                                @RequestParam(value = "minCalorie", required = false) Integer minCalorie,
                                @RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "canteen", required = false) String canteen) {
        // System.out.println(name);
        DishExample example = new DishExample();
        DishExample.Criteria criteria = example.createCriteria();
        if(!Strings.isNullOrEmpty(name)){
            criteria.andDishNameLike(name);
        }
        if(!Strings.isNullOrEmpty(category)){
            criteria.andCategoryEqualTo(category);
        }
        if(!Strings.isNullOrEmpty(category)){
            criteria.andCategoryEqualTo(category);
        }
        if(minPrice != null && minPrice > 0 && maxPrice != null && maxPrice > 0){
            criteria.andPriceBetween(minPrice, maxPrice);
        }
        if(minCalorie != null && minCalorie > 0 && maxCalorie != null && maxCalorie > minCalorie){
            criteria.andCaloriesBetween(minCalorie, maxCalorie);
        }
        if(!Collections.isEmpty(ingredients)){
            criteria.andIndegrentIn(ingredients);
        }
        if(!Collections.isEmpty(flavors)){
            criteria.andFlavorIn(flavors);
        }
        if(!Strings.isNullOrEmpty(canteen)){
            criteria.andCanteenEqualTo(canteen);
        }

        dishMapper.selectByExample(example);
        List<DishesItem> returnList = new ArrayList<>();
        returnList.add(new DishesItem("菜品名称", "13.2", "北京大学 学一食堂", 71, 1, 233, "123", 10));
        returnList.add(new DishesItem("番茄炒蛋", "99.9", "北京大学 学二食堂", 71, 5, 233, "1213", 10));
        QueryDishesItemResponse response = new QueryDishesItemResponse();
        response.setDishesItemList(returnList);
        return new Result(200, "", response);
    }

}
