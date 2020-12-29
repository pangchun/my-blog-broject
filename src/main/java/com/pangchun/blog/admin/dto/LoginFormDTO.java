package com.pangchun.blog.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户登录表单DTO
 *
 * @author : pangchun
 * @date : 2020-12-29 11:35
 * @description : DTO是用于展示层和服务层之间的数据传输对象;
 * @version : v1.0
 */
@ApiModel("用户登录表单DTO")
@Data
public class LoginFormDTO {

    /** 账户名 */
    @ApiModelProperty("账户名")
    private String account;

    /** 密码 */
    @ApiModelProperty("密码")
    private String password;
}
