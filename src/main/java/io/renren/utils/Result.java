package io.renren.utils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Integer DEFAULT_SUC_CODE = 200;
    private static final Integer DEFAULT_FAIL_CODE = 500;
    private String msg;
    private Integer code;
    private T data;

    private Result(T obj) {
        this.code = DEFAULT_SUC_CODE;
        this.msg = "success";
        this.data = obj;
    }

    private Result(Integer code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.data = t;
    }

    public static <T> Result<T> buildSuccessResult() {
        return new Result<>(null);
    }

    public static <T> Result<T> buildSuccessResult(T obj) {
        return new Result<>(obj);
    }

    public static <T> Result<T> buildFailedResult(Integer errcode, String errmsg, T obj) {
        return new Result<>(errcode, errmsg, obj);
    }

    public static <T> Result<T> buildFailedResult(Integer errcode, String errmsg) {
        return new Result<>(errcode, errmsg, null);
    }

    public static <T> Result<T> buildFailedResult(String errmsg) {
        return new Result<>(DEFAULT_FAIL_CODE, errmsg, null);
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}