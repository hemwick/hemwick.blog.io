package com.pujiang.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pujiang.blog.bean.Article;
import com.pujiang.blog.mapper.ArticleMapper;
import com.pujiang.blog.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FrontServiceImpl implements FrontService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public PageInfo<Article> getArticlePage(int page, int limit) {
        Article article = new Article();
        article.setStatus(1);
        PageHelper.startPage(page, limit);
        List<Article> list = articleMapper.getAll(article);
        PageInfo<Article> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }
}
