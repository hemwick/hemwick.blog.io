package com.pujiang.blog.service;

import com.pujiang.blog.util.ResBean;

import java.util.List;


public interface ImageService {
    List<String> getImageList(String path);
    ResBean deleteImage(String imgPath);
}
