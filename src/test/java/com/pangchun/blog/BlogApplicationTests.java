package com.pangchun.blog;

import com.pangchun.blog.support.utils.SHAUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.security.rsa.RSASignature;

import java.security.NoSuchAlgorithmException;

@SpringBootTest
class BlogApplicationTests {

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

}
