package com.pujiang.blog.controller.admin;

import com.pujiang.blog.bean.Article;
import com.pujiang.blog.bean.Category;
import com.pujiang.blog.bean.CategoryArticle;
import com.pujiang.blog.service.ArticleService;
import com.pujiang.blog.service.CategoryArticleService;
import com.pujiang.blog.util.ResBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/article")
@ResponseBody
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryArticleService categoryArticleService;

    @RequestMapping("/saveInfo")
    public ResBean saveInfo(Article article,Integer[] category){
        return articleService.saveInfo(article,category);
    }
    @RequestMapping("/getPage")
    public ResBean getPage(int offset,int limit,Article article){
        return articleService.getPage(offset,limit,article);
    }
    @RequestMapping("/getCategory")
    public List<CategoryArticle> getCategory(Integer aid){
        return categoryArticleService.getInfoByAid(aid);
    }
    @RequestMapping("/getById")
    public Article getById(Integer id){
        return articleService.getById(id);
    }
}
