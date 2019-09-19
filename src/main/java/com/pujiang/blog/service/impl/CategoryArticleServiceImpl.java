package com.pujiang.blog.service.impl;

import com.pujiang.blog.bean.CategoryArticle;
import com.pujiang.blog.mapper.CategoryArticleMapper;
import com.pujiang.blog.service.CategoryArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryArticleServiceImpl implements CategoryArticleService {

    @Autowired
    private CategoryArticleMapper categoryArticleMapper;

    @Override
    public List<CategoryArticle> getInfoByAid(Integer aid) {
        return categoryArticleMapper.getInfoByAid(aid);
    }


}
