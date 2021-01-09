package com.pangchun.blog.home.blog.exception;

import com.pangchun.blog.support.ErrorType;
import com.pangchun.blog.support.exception.ExceptionType;

/**
 * Blog自定义异常类型
 *
 * @author : pangchun
 * @date : 2021-1-09
 * @description : Blog自定义异常类型
 * @version : v1.0
 */
public enum BlogExceptionType implements ErrorType {
    /*系统错误*/
    SYSTEM_ERROR(10000,"系统错误"),
    /*参数错误*/
    PARAM_ERROR(20000, "参数错误"),
    /*数据不存在错误*/
    NOT_EXIST_ERROR(30000, "数据不存在错误");

    private int code;
    private String message;

    BlogExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return message;
    }
}
