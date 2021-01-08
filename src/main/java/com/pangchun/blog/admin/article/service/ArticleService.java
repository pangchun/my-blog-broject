package com.pangchun.blog.admin.article.service;

import com.pangchun.blog.admin.article.dto.ArticleDTO;
import com.pangchun.blog.admin.article.exception.ArticleExceptionType;
import com.pangchun.blog.admin.article.repository.ArticleRepository;
import com.pangchun.blog.entity.Article;
import com.pangchun.blog.support.ResponseResult;
import com.pangchun.blog.support.utils.AssertUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 文章service
 *
 * @author : pangchun
 * @date : 2021-1-05 22:15
 * @description : 实现文章存为草稿、发布等功能;
 * @version : v1.0
 */
@Service
public class ArticleService {

    @Resource
    ArticleRepository articleRepository;

    /**
     * 文章发布
     *
     * @param dto
     * @return
     */
    public ResponseResult<Article> publish(ArticleDTO dto) {
        //参数校验
        Helper.checkArticleParam(dto);

        //数据转换
        Article article = new Article();
        article.setTitle(dto.getTitle());
        article.setDescription(dto.getDescription());
        article.setPublishTime(new Date());
        article.setContent(dto.getContent());

        //保存文章
        Article savedArticle = articleRepository.save(article);

        //封装返回值
        ResponseResult<Article> result = new ResponseResult<>();
        if (savedArticle != null) {
            result.setCode(200);
            result.setMessage("Success");
            result.setData(savedArticle);
        }
        else {
            result.setCode(500);
            result.setMessage("文章发布失败");
        }

        return result;
    }

    /*辅助类*/
    private static class Helper {

        public static void checkArticleParam(ArticleDTO dto) {

            AssertUtils.notNull(dto.getTitle(), ArticleExceptionType.PARAM_ERROR,"请输入文章标题");
            AssertUtils.notNull(dto.getDescription(), ArticleExceptionType.PARAM_ERROR,"请输入文章描述");
            AssertUtils.notNull(dto.getContent(), ArticleExceptionType.PARAM_ERROR,"请输入文章内容");
        }
    }

}
