package com.pangchun.blog.home.blog.controller;

import com.pangchun.blog.entity.Article;
import com.pangchun.blog.home.blog.repository.BlogRepository;
import com.pangchun.blog.home.blog.service.BlogService;
import com.pangchun.blog.support.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * BlogAPI
 *
 * @author : pangchun
 * @date : 2021-1-07
 * @description : BlogAPI
 * @version : v1.0
 */
@Api(tags = "BlogAPI")
@Controller
@RequestMapping("/blog")
@Slf4j
public class BlogController {

    @Resource
    BlogService blogService;

    @ApiOperation("Blog-获取最新文章")
    @GetMapping("/latest")
    @ResponseBody
    public ResponseResult<Article> findLatestArticle(HttpServletRequest request) {

        log.info("获取最新文章");

        ResponseResult<Article> result = blogService.findLatestArticle();

        request.setAttribute("content",result.getData().getContent());

        return result;
    }


}
