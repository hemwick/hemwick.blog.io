package com.pujiang.blog.controller.front;

import com.github.pagehelper.PageInfo;
import com.pujiang.blog.bean.Article;
import com.pujiang.blog.bean.CategoryArticle;
import com.pujiang.blog.bean.Comment;
import com.pujiang.blog.service.ArticleService;
import com.pujiang.blog.service.CategoryArticleService;
import com.pujiang.blog.service.CommentService;
import com.pujiang.blog.service.FrontService;
import com.pujiang.blog.util.ResBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class FrontController {
    @Autowired
    private FrontService frontService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryArticleService categoryArticleService;
    @Autowired
    private CommentService commentService;
    @RequestMapping("/getArticle")
    public PageInfo<Article> getArticlePage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer limit){
        return frontService.getArticlePage(page,limit);
    }
    @RequestMapping("/getArticleById")
    public  Article getArticleById(Integer id){
        return articleService.getById(id);
    }

    @RequestMapping("/getCategoryName")
    public List<CategoryArticle> getCategory(Integer aid){
        return categoryArticleService.getInfoByAid(aid);
    }

    @RequestMapping("/addComment")
    public ResBean addComment(Comment comment){
        return commentService.updateComment(comment);
    }
}
