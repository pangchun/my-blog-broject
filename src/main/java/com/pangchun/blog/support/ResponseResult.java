package com.pangchun.blog.support;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

//TODO: 分页数据返回
/**
 * 统一响应结果
 *
 * @author : pangchun
 * @date : 2020-12-28 16:43
 * @description : 当请求需要返回给前端Json格式的数据时，统一使用这个响应结果返回
 * @version : v1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {

    public static final int SUCCESS = 200;
    public static final int ERROR = 500;
    private int code;
    private String message;
    private T data;
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalPage;
    private Long totalSize;

    public ResponseResult() {
    }


    public static <T> ResponseResult<T> error(int code, String message) {

        ResponseResult<T> responseResult = new ResponseResult();
        responseResult.code = code;
        responseResult.message = message;

        return responseResult;

    }

    public static <T> ResponseResult<T> error(String message) {
        return error(ERROR,message);
    }


    public static <T> ResponseResult<T> success(String message) {

        ResponseResult<T> responseResult = new ResponseResult();
        responseResult.code = SUCCESS;
        responseResult.message = message;

        return responseResult;

    }

    public static <T> ResponseResult<T> success(String message, T data) {

        ResponseResult<T> responseResult = success(message);
        responseResult.data = data;

        return responseResult;

    }

    public static <T> ResponseResult<T> success(T data) {
        return success("SUCCESS", data);
    }


    /*setter and getter*/

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }
}
