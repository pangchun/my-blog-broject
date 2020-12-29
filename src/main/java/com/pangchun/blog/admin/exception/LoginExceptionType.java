package com.pangchun.blog.admin.exception;

import com.pangchun.blog.support.ErrorType;

/**
 * 用户登录异常类型
 *
 * @author : pangchun
 * @date : 2020-12-29 13:19
 * @description : 用于定义用户登录发生的不同异常,注意多个枚举之间是用空格隔开;
 * @version : v1.0
 */
public enum LoginExceptionType implements ErrorType {

    /*系统错误*/
    SYSTEM_ERROR(10000,"系统错误"),
    /*参数错误*/
    PARAM_ERROR(20000, "参数错误"),
    /*数据不存在错误*/
    NOT_EXIST_ERROR(30000, "数据不存在错误");

    private int code;
    private String message;

    LoginExceptionType(int code, String message) {
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
