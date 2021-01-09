package com.pangchun.blog.home.blog.repository;

import com.pangchun.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

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

    /**
     * 找到小于指定日期的最新文章 - 对应页面上的Newer
     * 需要注意的是时区问题
     * @param publishTime
     * @return
     */
    Article findFirstByPublishTimeBeforeOrderByPublishTimeDesc(Date publishTime);

    /**
     * 找到大于指定日期的最旧文章 - 对应页面上的Older
     *
     * @param publishTime
     * @return
     */
    Article findFirstByPublishTimeAfterOrderByPublishTimeAsc(Date publishTime);



}
