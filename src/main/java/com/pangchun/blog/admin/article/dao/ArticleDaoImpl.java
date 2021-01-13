package com.pangchun.blog.admin.article.dao;

import com.pangchun.blog.admin.article.repository.ArticleRepository;
import com.pangchun.blog.entity.Article;
import com.pangchun.blog.support.ResponseResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章dao实现类
 *
 * @author : pangchun
 * @date : 2021-1-12 16:13
 * @description : 一些比较复杂的查询
 * @version : v1.0
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Resource
    ArticleRepository repository;

    /**
     * 分页查询所有文章
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public ResponseResult<List<Article>> findAllWithsPage(int page, int size) {

        //排序规则
        Sort orders = Sort.by(Sort.Direction.DESC, "aid");

        //分页规则 因为JPA是从0页开始查的，所以page-1
        PageRequest pageable = PageRequest.of(page-1, size, orders);

        //分页数据
        Page<Article> articlePage = repository.findAll(pageable);

        /** 取出分页数据 **/
        //文章List
        List<Article> articleList = articlePage.getContent();
        //第几页
        int pageNumber = articlePage.getNumber();
        //每页条数
        int pageSize = articlePage.getSize();
        //总页数
        int totalPages = articlePage.getTotalPages();
        //总条数
        long totalElements = articlePage.getTotalElements();

        //封装返回值
        ResponseResult<List<Article>> result = new ResponseResult<>();
        result.setData(articleList);
        //因为之前减了1，所以返回pageNumber+1
        result.setCurrentPage(pageNumber+1);
        result.setPageSize(pageSize);
        result.setTotalPage(totalPages);
        result.setTotalSize(totalElements);

        return result;
    }

}
