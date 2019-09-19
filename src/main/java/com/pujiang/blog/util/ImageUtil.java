package com.pujiang.blog.util;

import com.alibaba.druid.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    public static String uploadImg(String uploadPath, MultipartFile[] files) {
        if (files != null && files.length >= 1) {
            BufferedOutputStream bw = null;
            try {
                String fileName = files[0].getOriginalFilename();
                // 判断是否有文件
                if (!StringUtils.isEmpty(fileName)) {
                    String uploadFileName = MyUtil.getOrderID() + MyUtil.getFileSuff(fileName);
                    // 输出到本地路径
                    File outFile = new File(uploadPath + uploadFileName);
                    FileUtils.copyInputStreamToFile(files[0].getInputStream(), outFile);
                    return uploadFileName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(bw!=null){
                        bw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
