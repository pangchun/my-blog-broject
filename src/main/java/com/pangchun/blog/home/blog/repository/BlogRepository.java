package com.pangchun.blog.home.blog.repository;

import com.pangchun.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Blog数据访问层
 *
 * @author : pangchun
 * @date : 2021-1-07
 * @description : Blog数据访问层
 * @version : v1.0
 */
public interface BlogRepository extends JpaRepository<Article,Integer> {

    /**
     * 通过时间排序后获取最新文章
     * @return
     */
    Article findFirstByOrderByPublishTimeDesc();
}
