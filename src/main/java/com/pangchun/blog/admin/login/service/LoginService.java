package com.pangchun.blog.admin.login.service;

import com.pangchun.blog.admin.login.dto.LoginFormDTO;
import com.pangchun.blog.admin.login.exception.LoginExceptionType;
import com.pangchun.blog.admin.login.repository.LoginRepository;
import com.pangchun.blog.entity.User;
import com.pangchun.blog.support.ResponseResult;
import com.pangchun.blog.support.utils.AssertUtils;
import com.pangchun.blog.support.utils.SHAUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;

/**
 * 用户登录service
 *
 * @author : pangchun
 * @date : 2020-12-29 12:51
 * @description : 用户登入和退出后台的业务层;
 * @version : v1.0
 */
@Service
public class LoginService {

    @Resource
    private LoginRepository loginRepository;

    //TODO: 目前使用SHA1算法对密码加密， 以后改用springSecurity加密

    /**
     * 用户登录-登入
     *
     * @param loginFormDTO
     * @return
     */
    public ResponseResult<User> login(LoginFormDTO loginFormDTO) throws NoSuchAlgorithmException {

        //参数校验
        Helper.checkLoginParam(loginFormDTO);

        //从数据库拿到user,注意有可能用户不存在
        String account = loginFormDTO.getAccount();
        String password = SHAUtils.sha1(loginFormDTO.getPassword());
        User user = loginRepository.findByAccountAndPassword(account, password);

        //封装返回值
        ResponseResult<User> result = new ResponseResult<>();
        if (user != null) {
            result.setData(user);
            result.setCode(200);
            result.setMessage("Success");
        } else {
            result.setCode(400);
            result.setMessage("账号或密码有误");
        }

        return result;
    }

    /*辅助类*/
    private static class Helper {

        public static void checkLoginParam(LoginFormDTO dto) {

            AssertUtils.notNull(dto.getAccount(), LoginExceptionType.PARAM_ERROR,"请输入账户名");
            AssertUtils.notNull(dto.getPassword(), LoginExceptionType.PARAM_ERROR,"请输入密码");
        }
    }
}
