package com.pujiang.blog.service.impl;

import com.pujiang.blog.service.ImageService;
import com.pujiang.blog.util.FileUtil;
import com.pujiang.blog.util.ResBean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public List<String> getImageList(String path) {
        List<String> list = new ArrayList<>();
        /*初始化文件对象*/
        File file = new File(path);
        /*判断文件是否存在*/
        if (file.exists()){
            String[] fileNames = file.list();
            for (int i=0;i<fileNames.length;i++){
                list.add(fileNames[i]);
            }
        }
        return list;
    }

    @Override
    public ResBean deleteImage(String imgPath) {
        return new ResBean(FileUtil.deleteFile(imgPath));
    }
}
