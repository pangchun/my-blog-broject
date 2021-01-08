package com.pangchun.blog.home.blog.service;

import com.pangchun.blog.entity.Article;
import com.pangchun.blog.home.blog.repository.BlogRepository;
import com.pangchun.blog.support.ResponseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BlogService {

    @Resource
    BlogRepository blogRepository;

    public ResponseResult<Article> findLatestArticle() {

        //取出最新文章
        Article article = blogRepository.findFirstByOrderByPublishTimeDesc();

        //封装返回值
        ResponseResult<Article> result = new ResponseResult<>();
        if (article != null) {
            result.setCode(200);
            result.setMessage("Success");
            result.setData(article);
        }
        else {
            result.setCode(500);
            result.setMessage("获取最新文章失败");
        }

        return result;
    }
}
