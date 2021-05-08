package com.jimo.controller;

import com.jimo.model.dishes.DishesItem;
import com.jimo.vo.QueryDishesItemRequest;
import com.jimo.vo.QueryDishesItemResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author algorithm
 */
@RestController
@RequestMapping("/dishes")
public class DishesController {

    @GetMapping("/getList")
    public QueryDishesItemResponse getDishesList(@RequestBody QueryDishesItemRequest request){
        List<DishesItem> returnList = new ArrayList<>();
        returnList.add(new DishesItem("菜品名称", "13.2","北京大学 学一食堂", 71, 1,233,"123"));
        returnList.add(new DishesItem("番茄炒蛋", "99.9","北京大学 学二食堂", 71, 5,233,"1213"));
        QueryDishesItemResponse response = new QueryDishesItemResponse();
        response.setDishesItemList(returnList);
        return response;
    }
}
