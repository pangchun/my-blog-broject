package com.pangchun.blog.admin.article.dao;

import com.pangchun.blog.entity.Article;
import com.pangchun.blog.support.ResponseResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章dao
 *
 * @author : pangchun
 * @date : 2021-1-12 16:13
 * @description : 一些比较复杂的查询
 * @version : v1.0
 */
public interface ArticleDao {

    /**
     * 分页查询所有文章，排序是实现类默认的主键id降序
     *
     * @param page
     * @param size
     * @return
     */
    ResponseResult<List<Article>> findAllWithsPage(int page, int size);
}
