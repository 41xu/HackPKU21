package com.jimo.vo;

import com.jimo.vo.entity.ReviewItem;

import java.util.List;

/**
 * @author algorithm
 */
public class QueryReviewItemResponse {
    List<ReviewItem> reviewItemList;

    public List<ReviewItem> getReviewItemList() {
        return reviewItemList;
    }

    public void setReviewItemList(List<ReviewItem> reviewItemList) {
        this.reviewItemList = reviewItemList;
    }
}
