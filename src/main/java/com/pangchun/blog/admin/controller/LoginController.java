package com.pangchun.blog.admin.controller;

import com.pangchun.blog.admin.entity.LoginForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录博客后台
 *
 * @author : pangchun
 * @date : 2020-12-26 16:18
 * @description : 博客登录API
 * @version : v1.0
 */
@Controller
@RequestMapping
@Slf4j
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> loginCheck(@RequestBody LoginForm loginForm) {

        log.info(loginForm.toString());

        Map<String, Object> map = new HashMap<>();
        map.put("account",loginForm.getAccount());

        return map;
    }

}
