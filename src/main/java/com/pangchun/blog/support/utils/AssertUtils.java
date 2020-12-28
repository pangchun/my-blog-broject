package com.pangchun.blog.support.utils;

import com.pangchun.blog.support.ErrorType;
import com.pangchun.blog.support.exception.ServiceException;

/**
 * 断言工具类
 *
 * @author : pangchun
 * @date : 2020-12-28 23:22
 * @description : 公用得工具类，用于对前端传来的数据进行判断；可以在下方继续添加公用的断言，不符合断言条件就抛出异常;
 *               -> 灵活使用StringUtils、ObjectUtils、CollectionUtils等工具类可以更好地设置断言;
 * @version : v1.0
 */
public class AssertUtils {


    public AssertUtils() {
    }

    public static void notNull(Object object, ErrorType type) throws ServiceException {
        if (object == null) {
            throw new ServiceException(type);
        }
    }

    public static void notNull(Object object, ErrorType type, String message) throws ServiceException {
        if (object == null) {
            throw new ServiceException(type,message);
        }
    }

    public static void notNull(Object object, ErrorType type, Object... args) throws ServiceException {
        if (object == null) {
            throw new ServiceException(type,args);
        }
    }
}
