package com.pangchun.blog.admin.article.controller;

import com.pangchun.blog.admin.article.vo.FileUploadVO;
import com.pangchun.blog.support.utils.BasePathUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

//TODO: 以后会有头像上传等功能，需要将上传功能抽取成为一个通用工具类；
/**
 * 文章图片上传controller
 *
 * @author : pangchun
 * @date : 2021-1-04 9:32
 * @description : 编辑文章的图片上传
 * @version : v1.0
 */
@Api(tags = "文章API")
@RestController
@RequestMapping("/article")
@Slf4j
public class ImageUploadController {

    @ApiOperation("文章-上传图片")
    @PostMapping("/img-upload")
    public FileUploadVO imgUpload (@RequestParam("editormd-image-file") MultipartFile file, HttpServletRequest request) {

        //获取文件名
        String filename = file.getOriginalFilename();
        //文件类型后缀
        assert filename != null;
        String suffix = filename.substring(filename.lastIndexOf(".") + 1);
        //重命名文件
        String nickname = System.currentTimeMillis() + "." + suffix;
        //设置文件储存路径
        //String uploader = request.getServletContext().getRealPath("/") + "fileupload"; (这个是部署在云服务器时使用)
        String uploader = FileUploadVO.PATH;

        File dest = new File(uploader, nickname);

        log.info("文件上传目录：" + uploader);

        //检查是否存在目录
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            //将收到的文件传输到给定的目标文件。
            file.transferTo(dest);
            //返回Editor回调json格式：{success:1|0,message:"成功|失败",url:"url"}
            return new FileUploadVO(1,"上传成功", BasePathUtils.getBasePath(request)
                    + "/fileupload/" + nickname);
            //return new FileUploadVO(1,"上传成功",uploader + "\\" + nickname); (这个是部署在云服务器时使用)
        } catch (IOException e) {
            e.printStackTrace();
            return new FileUploadVO(0,"上传失败");
        }
    }
}
