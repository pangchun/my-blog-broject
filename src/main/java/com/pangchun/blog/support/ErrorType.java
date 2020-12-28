package com.pangchun.blog.support;

/**
 * 异常类型接口
 *
 * @author : pangchun
 * @date : 2020-12-27 12:13
 * @description : 定义一个所有自定义异常都需要实现的接口，自定义异常都获得getErrorCode()、getErrorMsg()方法
 * @version : v1.0
 */
public interface ErrorType {

    /**
     * 获得错误状态码
     *
     * @return 错误状态码
     */
    int getErrorCode();

    /**
     * 获得错误消息
     *
     * @return 错误消息
     */
    String getErrorMsg();
}
