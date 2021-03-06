package com.pangchun.blog.admin.article.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文章DTO
 *
 * @author : pangchun
 * @date : 2021-1-5 15:27
 * @description : 文章DTO
 * @version : v1.0
 */
@ApiModel("文章DTO")
@Data
public class ArticleDTO {

    /** 主键编号 */
    @ApiModelProperty("主键id")
    private Integer aid;

    /** 文章标题 */
    @ApiModelProperty("文章标题")
    private String title;

    /** 文章描述 */
    @ApiModelProperty("文章描述")
    private String description;

    /** 文章内容 */
    @ApiModelProperty("文章内容")
    private String content;

}
