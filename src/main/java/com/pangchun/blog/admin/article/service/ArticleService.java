package com.pangchun.blog.admin.article.service;

import com.pangchun.blog.admin.article.dao.ArticleDao;
import com.pangchun.blog.admin.article.dto.ArticleDTO;
import com.pangchun.blog.admin.article.exception.ArticleExceptionType;
import com.pangchun.blog.admin.article.repository.ArticleRepository;
import com.pangchun.blog.entity.Article;
import com.pangchun.blog.support.ResponseResult;
import com.pangchun.blog.support.utils.AssertUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

// TODO: 封装返回值的代码比较冗余，需要抽取一下;

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

    private static final String OK = "Success";

    @Resource
    ArticleRepository articleRepository;

    @Resource
    ArticleDao articleDao;

    /**
     * 文章发布
     *
     * @param dto
     * @return
     */
    public ResponseResult<Article> publish(ArticleDTO dto) {
        //参数校验
        Helper.checkArticleParam(dto);

        //数据转换 TODO：这里的数据转换可以使用MapStruct
        Article article = new Article();
        article.setAid(dto.getAid());
        article.setTitle(dto.getTitle());
        article.setDescription(dto.getDescription());
        article.setPublishTime(new Date());
        article.setContent(dto.getContent());

        //保存文章
        Article savedArticle = articleRepository.save(article);

        //封装返回值
        ResponseResult<Article> result = new ResponseResult<>();
            result.setCode(200);
            result.setMessage(OK);
            result.setData(savedArticle);

        return result;
    }

    /**
     * 分页查询所有文章，排序默认主键id降序
     *
     * @param page 第几页
     * @param size 每页几条
     * @return
     */
    public ResponseResult<List<Article>> findAllWithsPage(int page, int size) {

        //参数校验 TODO: 可能需要对page和size参数的最大值和最小值进行参数校验；
        AssertUtils.notNull(page, ArticleExceptionType.PARAM_ERROR,"请输入页码数");
        AssertUtils.notNull(size, ArticleExceptionType.PARAM_ERROR,"请输入每页条数");

        //获取数据
        ResponseResult<List<Article>> resultParam = articleDao.findAllWithsPage(page, size);

        //封装返回值
        ResponseResult<List<Article>> result = new ResponseResult<>();
        if (!ObjectUtils.isEmpty(resultParam.getData())) {
            result = resultParam;
            result.setCode(200);
            result.setMessage(OK);
        }
        else if (resultParam.getTotalSize()>0) {
            result.setCode(500);
            result.setMessage("您输入的页码数已经大于总页数，请输入更小的页码或者调小每页条数参数！！");
        }
        else {
            result.setCode(500);
            result.setMessage("因您太懒，一篇文章都未发布！！");
        }

        return result;
    }

    /**
     * 根据id查询指定文章
     *
     * @param aid
     * @return
     */
    public ResponseResult<Article> findByAid(Integer aid) {

        //参数校验
        AssertUtils.notNull(aid, ArticleExceptionType.PARAM_ERROR, "请传入文章aid");

        //获取数据
        Article article = articleRepository.findArticleByAid(aid);

        //封装返回值
        ResponseResult<Article> result = new ResponseResult<>();
        if (article != null) {
            result.setCode(200);
            result.setMessage(OK);
            result.setData(article);
        }
        else {
            result.setCode(500);
            result.setMessage("没有主键为" + aid + "的文章");
        }

        return result;
    }

    public ResponseResult<String> deleteByAid(Integer aid) {

        //参数校验
        AssertUtils.notNull(aid, ArticleExceptionType.PARAM_ERROR, "请传入文章aid");

        //删除数据
        articleRepository.deleteArticleByAid(aid);

        //封装返回值
        ResponseResult<String> result = new ResponseResult<>();
        result.setCode(200);
        result.setMessage("删除成功");

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
