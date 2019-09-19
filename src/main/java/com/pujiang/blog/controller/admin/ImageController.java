package com.pujiang.blog.controller.admin;

import com.pujiang.blog.service.ImageService;
import com.pujiang.blog.util.ImageUtil;
import com.pujiang.blog.util.ResBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/image")
@ResponseBody
public class ImageController {
    @Autowired
    private ImageService imageService;

    @RequestMapping("/upload")
    public ResBean upload(HttpServletRequest request, @RequestParam("file") MultipartFile[] files){
        /*获取文件存放的真实路径*/
        String path = request.getServletContext().getRealPath("/upload")+"/";
        String fileName= ImageUtil.uploadImg(path,files);
        if (StringUtils.isEmpty(fileName)){
            return new ResBean(0);
        }
            return new ResBean(1);
    }
    @RequestMapping("/getImageList")
    public List<String> getImageList(HttpServletRequest request){
        String path = request.getServletContext().getRealPath("/upload")+"/";
        return imageService.getImageList(path);
    }
    @RequestMapping("/deleteImage")
    public ResBean deleteImage(HttpServletRequest request,String fileName){
        String path = request.getServletContext().getRealPath("/upload")+"/";
        String imagePath=path+fileName;
        return imageService.deleteImage(imagePath);
    }
}
