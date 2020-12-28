package com.pangchun.blog.support.exception;

import com.pangchun.blog.support.ErrorType;

/**
 * 业务层异常类
 *
 * @author : pangchun
 * @date : 2020-12-28 11:33
 * @description : 定义异常类，用于抛出异常，并交给ExceptionHandler管理
 * @version : v1.0
 */
public class ServiceException extends RuntimeException {

    private ErrorType errorType;
    private Object[] args;

    public ServiceException(ErrorType errorType) {
        this(errorType,errorType.getErrorMsg());
    }

    /**
     * 其他所有构造方法最终都会转到此构造方法，并执行 super(message);
     *
     * @param errorType
     * @param message 设置错误信息,message是父类Throwable的属性：detailMessage
     */
    public ServiceException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    /**
     *
     * @param errorType
     * @param args 可变参数：可以添加多个错误信息
     */
    public ServiceException(ErrorType errorType, Object... args) {
        this(errorType);
        this.args = args;
    }

    /*getter and setter*/

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
