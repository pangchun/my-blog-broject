package com.pangchun.blog.home.blog.service;

import com.pangchun.blog.entity.Article;
import com.pangchun.blog.home.blog.exception.BlogExceptionType;
import com.pangchun.blog.home.blog.repository.BlogRepository;
import com.pangchun.blog.support.ResponseResult;
import com.pangchun.blog.support.utils.AssertUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

//TODO: 相同的代码要抽取为公共片段
/**
 * Blog业务层
 *
 * @author : pangchun
 * @date : 2021-1-07
 * @description : Blog业务层
 * @version : v1.0
 */
@Service
public class BlogService {

    @Resource
    BlogRepository blogRepository;

    /**
     * 获取最新文章
     *
     * @return
     */
    public ResponseResult<Article> findLatestArticle() {

        //取出最新文章
        Article article = blogRepository.findFirstByOrderByPublishTimeDesc();

        //封装返回值
        ResponseResult<Article> result = Helper.encapsulate(article, "作者很懒，还未发布过文章呢");

        return result;
    }

    /**
     * 获取小于指定时间的最新文章
     *
     * @param publishTime
     * @return
     */
    public ResponseResult<Article> findNewerArticle(Date publishTime) {

        //参数校验
        Helper.checkPublishTimeParam(publishTime);

        //取出距离给定时间最新的文章
        Article article = blogRepository.findFirstByPublishTimeBeforeOrderByPublishTimeDesc(publishTime);

        //封装返回值
        ResponseResult<Article> result = Helper.encapsulate(article, "已经到底啦");

        return result;
    }

    /**
     * 获取大于指定时间的最旧文章
     *
     * @param publishTime
     * @return
     */
    public ResponseResult<Article> findOlderArticle(Date publishTime) {

        //参数校验
        Helper.checkPublishTimeParam(publishTime);

        //获取大于指定时间的最旧文章
        Article article = blogRepository.findFirstByPublishTimeAfterOrderByPublishTimeAsc(publishTime);

        //封装返回值
        ResponseResult<Article> result = Helper.encapsulate(article, "已经是最新文章啦");

        return result;
    }

    /* 辅助类 */
    private static class Helper {

        /**
         * 验证指定时间
         *
         * @param date
         */
        public static void checkPublishTimeParam(Date date) {

            AssertUtils.notNull(date, BlogExceptionType.NOT_EXIST_ERROR,"请输入发布时间");
        }

        /**
         * 封装返回值
         *
         * @param article
         * @param fail_message 文章为空时返回给前端的错误消息
         * @return
         */
        public static ResponseResult<Article> encapsulate(Article article, String fail_message) {

            ResponseResult<Article> result = new ResponseResult<>();

            if (article != null) {
                result.setCode(200);
                result.setMessage("Success");
                result.setData(article);
            }
            else {
                result.setCode(500);
                result.setMessage(fail_message);
            }

            return result;
        }
    }
}
