package com.pangchun.blog.admin.controller;

import com.pangchun.blog.admin.dto.LoginFormDTO;
import com.pangchun.blog.admin.service.LoginService;
import com.pangchun.blog.entity.User;
import com.pangchun.blog.support.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;

/**
 * 登录博客后台
 *
 * @author : pangchun
 * @date : 2020-12-26 16:18
 * @description : 博客登录API
 * @version : v1.0
 */
@Api(tags = "用户登录API")
@Controller
@RequestMapping
@Slf4j
public class LoginController {

    @Resource
    private LoginService loginService;

    @ApiOperation("用户登录-登入")
    @PostMapping("/login")
    @ResponseBody
    public ResponseResult<User> loginCheck(@RequestBody LoginFormDTO loginFormDTO) throws NoSuchAlgorithmException {

        log.info(loginFormDTO.toString());

        return loginService.login(loginFormDTO);
    }

}
