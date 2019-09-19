package com.pujiang.blog.service;

import com.pujiang.blog.bean.Article;
import com.pujiang.blog.util.ResBean;

public interface ArticleService {
    ResBean saveInfo(Article article,Integer[] category);
    ResBean getPage(int offset,int limit, Article article);
    Article getById(Integer id);
}
