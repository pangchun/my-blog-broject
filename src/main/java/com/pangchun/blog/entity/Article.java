package com.pangchun.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

//TODO: 继承文章状态，完成保存草稿功能；

/**
 * 文章实体类
 *
 * @author : pangchun
 * @date : 2021-1-5 15:27
 * @description : 文章实体类
 * @version : v1.0
 */
@ApiModel("文章实体")
@Data
@Entity
public class Article {

    /** 主键编号 */
    @ApiModelProperty("主键id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    /** 文章标题 */
    @ApiModelProperty("文章标题")
    private String title;

    /** 文章描述 */
    @ApiModelProperty("文章描述")
    private String description;

    /** 发布时间 */
    @ApiModelProperty("发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishTime;

    /** 文章内容 */
    @ApiModelProperty("文章内容")
    private String content;

}
