package com.pangchun.blog.support.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * 开启Swagger2
 *
 * @author : pangchun
 * @date : 2020-12-26 16:36
 * @description : 访问地址：http://localhost:8081/swagger-ui.html
 * @version : v1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * 配置了Swagger的Docket的bean实例
     *
     */
    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("pangchun")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RequestMapping.class))
                .build();
    }

    /**
     * 配置Swagger信息-apiInfo
     *
     */
    public ApiInfo apiInfo() {

        return new ApiInfo(
                "my-blog-project API",
                "pangchun的独立博客API文档",
                "v1.0",
                "https://segmentfault.com/u/pangchun_5fade97ba2b56/articles",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }

    /**
     * 文档作者信息
     */
    Contact contact = new Contact(

            "pangchun",
            "https://github.com/pangchun",
            "pangchun_mail@qq.com"
    );
}
