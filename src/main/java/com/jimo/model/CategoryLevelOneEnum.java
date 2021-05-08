package com.jimo.model;

/**
 * @author algorithm
 */

public enum CategoryLevelOneEnum {
    BREAKPOINT("BreakPoint", 0), MEAL("Meal", 1), SNACK("Snack", 2);

    private String name;
    private Integer code;

    CategoryLevelOneEnum(String name, Integer code) {
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
