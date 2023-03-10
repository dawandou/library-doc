package com.captian.util;

import com.captian.constant.Constants;

import java.io.Serializable;

/**
 * @author: Captian
 *
 * @create: 2023-01-06
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = Constants.SUCCESS;
    /**
     * 失败
     */
    public static final int error = Constants.FAIL;
    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> success() {
        return result(null, SUCCESS, "操作成功");
    }

    public static <T> Result<T> success(T data) {
        return result(data, SUCCESS, "操作成功");
    }


    public static <T> Result<T> error() {
        return result(null, error, "操作失败");
    }

    public static <T> Result<T> error(String msg) {
        return result(null, error, msg);
    }

    public static <T> Result<T> error(T data) {
        return result(data, error, "操作失败");
    }

    private static <T> Result<T> result(T data, int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
