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
import java.util.List;

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

        log.info("发布文章： aid=" + articleDTO.getAid() + " title=" + articleDTO.getTitle());

        return articleService.publish(articleDTO);
    }

    /** 特别注意：jpa的分页查询是从0页开始查的, page参数最小值为0; */
    @ApiOperation("文章-分页")
    @PostMapping("/find-all-with-sPage")
    @ResponseBody
    public ResponseResult<List<Article>> findAllWithsPage(int page, int pageSize) {

        log.info("页码参数： " + page + " , 条数参数： " + pageSize);

        return articleService.findAllWithsPage(page, pageSize);
    }

    @ApiOperation("文章-查询")
    @GetMapping("/find-by-aid")
    @ResponseBody
    public ResponseResult<Article> findByAid(@RequestParam Integer aid) {

        log.info("文章aid： " + aid);

        return articleService.findByAid(aid);
    }

    @ApiOperation("文章-删除")
    @DeleteMapping("/delete-by-aid")
    @ResponseBody
    public ResponseResult<String> deleteByAid(@RequestParam Integer aid) {

        log.info("文章aid： " + aid);

        return articleService.deleteByAid(aid);
    }
}
