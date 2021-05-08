package com.jimo.model.common;

/**
 * 封装统一的返回数据
 * @author jimo
 * @date 2018/8/24 22:46
 */
public class Result {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 错误消息或其他提示
     */
    private String msg;
    /**
     * 数据
     */
    private Object results;

    public Result(Integer code, String msg, Object results) {
        this.code = code;
        this.msg = msg;
        this.results = results;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Result(String login){

    }
    public Result(boolean bool){

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }
}
