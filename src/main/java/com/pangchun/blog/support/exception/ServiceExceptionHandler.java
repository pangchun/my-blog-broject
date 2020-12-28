package com.pangchun.blog.support.exception;

import com.pangchun.blog.support.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常处理器
 *
 * @author : pangchun
 * @date : 2020-12-28 17:43
 * @description : 所有的自定义异常需要throw时，都自动来到这里处理，可以返回Json数据，也可以转发到/error请求
 * @version : v1.0
 */
@ControllerAdvice
public class ServiceExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ServiceExceptionHandler.class);

    /**
     * 处理ServiceException异常，返回Json数据
     *
     * @param ex 异常
     * @return 这里的返回值不加泛型可能会导致阿里巴巴代码规范报错，不知道带什么泛型时，带上String即可
     */
    @ExceptionHandler({ServiceException.class})
    @ResponseBody
    public ResponseResult<String> handelServiceException(ServiceException ex) {

        log.error("ServiceException",ex);

        return ResponseResult.error(ex.getErrorType().getErrorCode(),ex.getMessage());

    }
}
