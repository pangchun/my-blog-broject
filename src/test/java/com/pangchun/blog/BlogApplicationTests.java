package com.pangchun.blog;

import com.pangchun.blog.home.blog.repository.BlogRepository;
import com.pangchun.blog.support.utils.SHAUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.security.rsa.RSASignature;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@SpringBootTest
class BlogApplicationTests {

    @Resource
    BlogRepository blogRepository;

    /**
     * 测试SHA1算法加密密码
     *
     * @throws NoSuchAlgorithmException
     */
    @Test
    void contextLoads() throws NoSuchAlgorithmException {

        String admin = SHAUtils.sha1("admin");
        System.out.println(admin);
    }

    @Test
    void contextLoads2() throws NoSuchAlgorithmException {

        System.out.println(System.getProperty("user.dir"));
        //输出： F:\github_repositories\my-blog-project\my-blog-broject
    }

    @Test
    void contextLoads3() {

        System.out.println(blogRepository.findFirstByOrderByPublishTimeDesc().toString());
    }

    @Test
    void contextLoads4() {
        System.out.println(blogRepository.findFirstByPublishTimeBeforeOrderByPublishTimeDesc(new Date()));
    }

    @Test
    void contextLoads5() {
        System.out.println(new Date());
    }
}
