package com.pujiang.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pujiang.blog.bean.Article;
import com.pujiang.blog.bean.Category;
import com.pujiang.blog.bean.CategoryArticle;
import com.pujiang.blog.mapper.ArticleMapper;
import com.pujiang.blog.mapper.CategoryArticleMapper;
import com.pujiang.blog.service.ArticleService;
import com.pujiang.blog.util.MyUtil;
import com.pujiang.blog.util.ResBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl  implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CategoryArticleMapper categoryArticleMapper;
    @Override
    public ResBean saveInfo(Article article, Integer[] category) {
        if (article.getId()==null){
            /*2019-09-16 09:01:22*/
            article.setCreated(MyUtil.nowDate());
            /*添加文章信息*/
            if (articleMapper.insertSelective(article)>0){
                return formatterList(article,category);
            }
            return new ResBean(0);
        }
        article.setCreated(MyUtil.nowDate());
        if (articleMapper.updateByPrimaryKeySelective(article)>0){
            /*获取文章分类个数*/
            List<CategoryArticle> caList = categoryArticleMapper.getInfoByAid(article.getId());
            int result = categoryArticleMapper.deleteByAid(article.getId());
            if (caList.size()==result){
                return formatterList(article,category);
            }else{
                throw new Error("删除个数和分类个数不同");
            }
        }
        return new ResBean(0);
    }

    private ResBean formatterList(Article article,Integer[] category){
        if (category.length>0){//如果数组为空不需要封装
            List<CategoryArticle> list = new ArrayList<>();
            /*遍历数组分装集合*/
            for (Integer cid:category){
                CategoryArticle categoryArticle = new CategoryArticle();
                categoryArticle.setAid(article.getId());
                categoryArticle.setCid(cid);
                list.add(categoryArticle);
            }
            if (categoryArticleMapper.batchInsert(list) == list.size()) {
                return new ResBean(1);
            }else {
                throw new Error("成功数量和传入数量不一致");
            }
        }
        return new ResBean(0);
    }

    @Override
    public ResBean getPage(int offset, int limit, Article article) {
        /*根据offset偏移量，计算page当前页的值*/
        int page = offset/limit+1;
        /*拆分日期范围*/
        if (StringUtils.isNotEmpty(article.getCreated())){
            String[] date=article.getCreated().split(" - ");
            article.setCreated(date[0]);
            article.setUpdated(date[1]);
        }
        PageHelper.startPage(page,limit);
        List<Article> list=articleMapper.getAll(article);
        PageInfo<Article> pageInfo = new PageInfo<>(list);
        return new ResBean(list,pageInfo.getTotal());
    }

    @Override
    public Article getById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
