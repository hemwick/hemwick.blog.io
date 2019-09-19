package com.pujiang.blog.service;

import com.pujiang.blog.bean.CategoryArticle;

import java.util.List;

public interface CategoryArticleService {
    List<CategoryArticle> getInfoByAid(Integer aid);

}
