package com.pangchun.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author : pangchun
 * @date : 2020-12-29 11:12
 * @description : 使用后台的用户的基本属性
 * @version : v1.0
 */
@Data
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -2849580479735512274L;

    /** 主键编号 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    /** 账户名 */
    private String account;

    /** 密码 */
    private String password;

    /** email */
    private String email;

}
