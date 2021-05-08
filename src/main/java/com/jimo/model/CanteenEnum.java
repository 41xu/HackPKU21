package com.jimo.model;

/**
 * @author algorithm
 */
public enum CanteenEnum {
    XueYi("XueYi", 0), JiaYuan1("JiaYuan1", 1);

    /**
     * 菜品名称
     */
    String name;
    /**
     * 菜品代码
     */
    Integer code;

    CanteenEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

