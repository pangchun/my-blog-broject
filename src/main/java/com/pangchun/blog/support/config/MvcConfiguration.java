package com.pangchun.blog.support.config;

import org.springframework.context.annotation.Configuration;
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
        registry.addViewController("/").setViewName("admin/login");
        registry.addViewController("/admin").setViewName("admin/login");
        registry.addViewController("/admin/driver").setViewName("admin/driver");
    }
}
