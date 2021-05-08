package com.jimo.model.common;

import com.jimo.utils.MyConsts;

/**
 * 分页请求
 * @author algorithm
 */
public class PageRequest {
    /**
     * 当前页码 start from 1, default 1
     */
    private int pageNum = MyConsts.DEFAULT_PAGE_BEGIN;
    /**
     * 每页数量
     */
    private int pageSize = MyConsts.DEFAULT_PAGE_SIZE;

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}