package com.pangchun.blog.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author : pangchun
 * @date : 2021-1-18 17:45
 * @description : 标签实体类
 * @version : v1.0
 */
@ApiModel("标签实体")
@Data
@Entity
public class Tag {

    /** 主键编号 */
    @ApiModelProperty("主键id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    /** 文章标题 */
    @ApiModelProperty("标签名字")
    private String tagName;

    /** 文章标题 */
    @ApiModelProperty("标签描述")
    private String description;
}
