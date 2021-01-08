package com.pangchun.blog.admin.article.controller;

import com.pangchun.blog.admin.article.dto.ArticleDTO;
import com.pangchun.blog.admin.article.service.ArticleService;
import com.pangchun.blog.entity.Article;
import com.pangchun.blog.support.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//TODO：文章发布可以通过添加文章到数据库，添加发布时间字段，通过取出发布时间最新的文章显示到前端页面即可;
/**
 * 文章API
 *
 * @author : pangchun
 * @date : 2021-1-05 15:36
 * @description : 文章API
 * @version : v1.0
 */
@Api(tags = "文章API")
@Controller
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    @Resource
    ArticleService articleService;

    @ApiOperation("文章-发布")
    @PostMapping("/publish")
    @ResponseBody
    public ResponseResult<Article> publish(@RequestBody ArticleDTO articleDTO) {

        log.info(articleDTO.toString());

        return articleService.publish(articleDTO);
    }
}
