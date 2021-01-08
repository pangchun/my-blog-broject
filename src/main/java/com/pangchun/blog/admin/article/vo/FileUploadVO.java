package com.pangchun.blog.admin.article.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 文件上传结果VO
 *
 * @author : pangchun
 * @date : 2021-1-04 17:18
 * @description : VO是返回给前端的数据传输对象;
 * @version : v1.0
 */
@ApiModel("文件上传结果VO")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class FileUploadVO {

    /** 上传路径 */
    @ApiModelProperty("上传路径")
    public static final String PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\fileupload\\";

    /** 上传结果 */
    @ApiModelProperty("上传结果 1|0")
    @NonNull
    private Integer success;

    /** 响应描述 */
    @ApiModelProperty("响应描述")
    @NonNull
    private String message;

    /** 图片链接 */
    @ApiModelProperty("返回的图片链接")
    private String url;

}
