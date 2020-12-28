package com.pangchun.blog.support.exception;

import com.pangchun.blog.support.ErrorType;

/**
 * 异常类型枚举类
 *
 * @author : pangchun
 * @date : 2020-12-27 14:50
 * @description : 定义异常类型枚举类，实现ErrorType接口;
 * @version : v1.0
 */
public enum ExceptionType implements ErrorType {

    /*系统错误*/
    SYSTEM_ERROR(10000,"系统错误");

    private int code;
    private String message;

    ExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public int getErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMsg() {
        return this.message;
    }
}
