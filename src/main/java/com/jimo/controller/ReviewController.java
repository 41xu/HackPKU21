package com.jimo.controller;


import com.jimo.mapper.DishMapper;
import com.jimo.mapper.DishPictureMapper;
import com.jimo.mapper.ReviewMapper;
import com.jimo.model.*;
import com.jimo.model.common.Result;
import com.jimo.utils.MyConsts;
import com.jimo.utils.TimeUtils;
import com.jimo.vo.QueryReviewItemResponse;
import com.jimo.vo.entity.ReviewItem;
import io.jsonwebtoken.lang.Collections;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;;
import java.util.List;

/**
 * @author algorithm
 */
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishPictureMapper dishPictureMapper;


    @GetMapping("/getList")
    public Result getReviewList(@RequestParam(value = "dishId", required = false) String dishId,
                                @RequestParam(value = "page", required = false) Integer page) {
        // 查询是否存在这个dishId
        DishExample dishExample = new DishExample();
        dishExample.createCriteria().andDishIdEqualTo(dishId);
        List<Dish> dishRes = dishMapper.selectByExample(dishExample);
        if (Collections.isEmpty(dishRes)) {
            return new Result(500, "invalid dishId: " + dishId);
        }
        // 查询所有Review
        ReviewExample example = new ReviewExample();
        example.createCriteria().andDishIdEqualTo(dishId);
        int offset = (page == null) ? 0 : (page - MyConsts.DEFAULT_PAGE_BEGIN) * MyConsts.DEFAULT_PAGE_SIZE;
        RowBounds rowBounds = new RowBounds(offset, MyConsts.DEFAULT_PAGE_SIZE);
        List<ReviewItem> retList = new ArrayList<>();
        List<Review> reviewList = reviewMapper.selectByExampleWithRowbounds(example, rowBounds);

        // 每个dish 查询所有pictureUrl
        DishPictureExample dishPictureExample = new DishPictureExample();
        dishPictureExample.createCriteria().andDishIdEqualTo(dishId);
        List<DishPicture> dpList = dishPictureMapper.selectByExample(dishPictureExample);

        for (Review review : reviewList) {
            ReviewItem reviewItem = new ReviewItem();
            reviewItem.setId(review.getReviewId());
            reviewItem.setUserId(review.getUserId());

            // todo 类型可能不对
            System.out.println(review.getCreateDate());
            reviewItem.setTime(TimeUtils.getISO8601Timestamp(review.getCreateDate()));
            reviewItem.setRate(review.getRate());
            reviewItem.setDescription(review.getDescription());
            // todo 可能会出错？俺也不知
            reviewItem.setFlavor(review.getFlavor());
            reviewItem.setWaitTime(review.getWaitTime());
            reviewItem.setPrice(review.getPrice());
            reviewItem.setCategory(dishRes.get(0).getCategory());
            // todo 添加照片
            List<String> pictureUrlList = new ArrayList<>();
            for(DishPicture dp:dpList){
                if(dp.getReviewId().equals(review.getReviewId())){
                    pictureUrlList.add(dp.getPictureUrl());
                }
            }
            reviewItem.setPictureUrls(pictureUrlList);
            retList.add(reviewItem);
        }

        QueryReviewItemResponse response = new QueryReviewItemResponse();
        response.setReviewItemList(retList);
        return new Result(200, "", response);
    }
}
