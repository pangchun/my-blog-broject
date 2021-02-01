package com.pangchun.blog.support.config;

import com.pangchun.blog.admin.article.vo.FileUploadVO;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * webMVC的自定义配置
 *
 * @author : pangchun
 * @date : 2020-12-26 16:07
 * @description : 关于webMVC的自定义配置文件
 * @version : v1.0
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    /**
     * 配置视图控制器，用于替换页面跳转的controller
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("admin/login");
        registry.addViewController("/admin").setViewName("admin/login");
        registry.addViewController("/admin/dashboard").setViewName("admin/dashboard");
        registry.addViewController("/admin/editArticles").setViewName("admin/editArticles");
        registry.addViewController("/admin/manageArticles").setViewName("admin/manageArticles");
        registry.addViewController("/").setViewName("home/blog");
    }

    /**
     * 配置静态资源文件，实现文章图片上传回显;
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //获取文件的真实路径
        String path = FileUploadVO.PATH;

        //注意：这里的addResourceLocations不能用绝对路径，如：C:/user/...
        registry.addResourceHandler("/fileupload/**")
                .addResourceLocations("file:" + path);
    }
}

/*
* 参考链接： https://blog.csdn.net/qq_36845328/article/details/84782967?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.baidujs&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.baidujs
*
* addResourceHandler()里配置需要映射的文件夹，此处代表映射文件夹user下的所有资源。
* addResourceLocations()配置文件夹在系统中的路径，使用绝对路径，格式为“file:你的路径”
* */
