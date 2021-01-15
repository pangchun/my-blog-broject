package com.pangchun.blog.admin.article.repository;

import com.pangchun.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

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

    /**
     * 通过aid删除一篇文章
     *注意1：JPA的插入和删除语句执行之前都会自动执行查询语句，
     * 当记录存在时，执行更新和删除操作；
     * 当记录不存在时，执行插入操作，删除操作不执行；
     * 注意2：@Modifying、@Transactional注解必须加上，删除失败要进行回滚；
     * @param aid
     */
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    void deleteArticleByAid(Integer aid);

}
