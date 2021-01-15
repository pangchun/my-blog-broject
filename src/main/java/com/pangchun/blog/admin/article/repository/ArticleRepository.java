package com.pangchun.blog.admin.article.repository;

import com.pangchun.blog.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 文章repository
 *
 * @author : pangchun
 * @date : 2021-1-05 22:15
 * @description : 文章管理的数据访问层;
 * @version : v1.0
 */
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    /**
     * 通过aid查询一篇文章
     *
     * @param aid
     * @return
     */
    Article findArticleByAid(Integer aid);

}
