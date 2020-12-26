package com.pangchun.blog.admin.controller;

import com.pangchun.blog.admin.entity.LoginForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping
@Slf4j
public class LoginController {

    @GetMapping({"/admin"})
    public String goToLoginPage() {return "admin/login";}

    @PostMapping(value = {"/login"})
    @ResponseBody
    public Map<String,Object> loginCheck(@RequestBody LoginForm loginForm) {

        log.info(loginForm.toString());

        Map<String, Object> map = new HashMap<>();
        map.put("account",loginForm.getAccount());

        return map;
    }

}
