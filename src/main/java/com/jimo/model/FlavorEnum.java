package com.jimo.model;

public enum FlavorEnum {
    Spicy("Spicy", 0), Sour("Sour", 1), Sweet("Sweet", 2), Bitter("Bitter", 3);
    String name;
    Integer code;

    FlavorEnum(String name, Integer code) {
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
