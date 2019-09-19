package com.pujiang.blog.service;

import com.github.pagehelper.PageInfo;
import com.pujiang.blog.bean.Article;

public interface FrontService {
    PageInfo<Article> getArticlePage(int page,int limit);
}
