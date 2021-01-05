package com.pangchun.blog.article.exception;

import com.pangchun.blog.support.ErrorType;

/**
 * 文章异常类型
 *
 * @author : pangchun
 * @date : 2021-1-05 22:17
 * @description : 文章异常类型;
 * @version : v1.0
 */
public enum ArticleExceptionType implements ErrorType {

    /*系统错误*/
    SYSTEM_ERROR(10000,"系统错误"),
    /*参数错误*/
    PARAM_ERROR(20000, "参数错误"),
    /*数据不存在错误*/
    NOT_EXIST_ERROR(30000, "数据不存在错误");

    private int code;
    private String message;

    ArticleExceptionType(int code, String message) {
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
