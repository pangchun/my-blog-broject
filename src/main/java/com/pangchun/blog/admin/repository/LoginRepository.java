package com.pangchun.blog.admin.repository;

import com.pangchun.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户登录repository
 *
 * @author : pangchun
 * @date : 2020-12-29 11:44
 * @description : 用户登入和退出后台的数据访问层;
 * @version : v1.0
 */
public interface LoginRepository extends JpaRepository<User,Integer> {

    /**
     * 通过账户名和密码查询用户
     *
     * @param account 账户名参数
     * @param password 密码参数
     * @return 用户实体
     */
    User findByAccountAndPassword(String account, String password);
}
