package com.pujiang.blog.mapper;

import com.pujiang.blog.bean.Category;
import com.pujiang.blog.bean.CategoryArticle;

import java.util.List;

public interface CategoryArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryArticle record);

    int insertSelective(CategoryArticle record);

    CategoryArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryArticle record);

    int updateByPrimaryKey(CategoryArticle record);

    int batchInsert(List<CategoryArticle> list);

    List<CategoryArticle> getInfoByAid(Integer aid);

    int deleteByAid(Integer aid);

    int getCountByCid(Integer cid);
}