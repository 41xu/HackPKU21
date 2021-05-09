package com.jimo.model.enums;

/**
 * @author algorithm
 */
public enum CanteenEnum {
    XueYi("XueYi", 0), JiaYuan1("JiaYuan1", 1), JiaYuan2("JiaYuan2", 2),
    JiaYuan3("JiaYuan3", 3), JiaYuan4("JiaYuan4", 4), NongYuan1("NongYuan1", 5),
    NongYuan2("NongYuan2", 6), NongYuan3("NongYuan3", 7);

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

