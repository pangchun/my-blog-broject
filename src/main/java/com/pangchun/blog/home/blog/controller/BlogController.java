package com.pangchun.blog.home.blog.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pangchun.blog.entity.Article;
import com.pangchun.blog.home.blog.repository.BlogRepository;
import com.pangchun.blog.home.blog.service.BlogService;
import com.pangchun.blog.support.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * BlogAPI
 *
 * @author : pangchun
 * @date : 2021-1-07
 * @description : BlogAPI
 * @version : v1.0
 */
@Api(tags = "博客API")
@Controller
@RequestMapping("/blog")
@Slf4j
public class BlogController {

    @Resource
    BlogService blogService;

    @ApiOperation("博客-最新文章")
    @GetMapping("/latest")
    @ResponseBody
    public ResponseResult<Article> findLatestArticle() {

        log.info("获取最新文章");

        ResponseResult<Article> result = blogService.findLatestArticle();

        return result;
    }

    @ApiOperation("博客-下一篇文章")
    @GetMapping("/newer")
    @ResponseBody
    public ResponseResult<Article> findNewerArticle(@RequestParam("publishTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date publishTime) {

        log.info("指定发布时间: " + publishTime.toString());

        ResponseResult<Article> result = blogService.findNewerArticle(publishTime);

        return result;
    }

    @ApiOperation("博客-上一篇文章")
    @GetMapping("/older")
    @ResponseBody
    public ResponseResult<Article> findOlderArticle(@RequestParam("publishTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date publishTime) {

        log.info("指定发布时间: " + publishTime.toString());

        ResponseResult<Article> result = blogService.findOlderArticle(publishTime);

        return result;
    }


}
