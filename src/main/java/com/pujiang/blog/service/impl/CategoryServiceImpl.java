package com.pujiang.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pujiang.blog.bean.Category;
import com.pujiang.blog.bean.CategoryArticle;
import com.pujiang.blog.mapper.CategoryArticleMapper;
import com.pujiang.blog.mapper.CategoryMapper;
import com.pujiang.blog.service.CategoryService;
import com.pujiang.blog.util.ResBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryArticleMapper categoryArticleMapper;

    @Override
    public ResBean getPage(int offset, int limit, Category category) {
        int page = offset / limit + 1;
        /*执行分页插件 一定奥谢在一查询语句的上i行业，中间不能再用任何其他代码*/
        PageHelper.startPage(page,limit);//page当前页，limit每页条数
        List<Category> list = categoryMapper.getAll(category);
        /*封装分页数据信息*/
        PageInfo<Category> pageInfo = new PageInfo<>(list);
        return new ResBean(list,pageInfo.getTotal());
    }

    @Override
    public ResBean saveInfo(Category category) {
        if (category.getId()==null){
            return new ResBean(categoryMapper.insertSelective(category));
        }
        return new ResBean(categoryMapper.updateByPrimaryKeySelective(category));
    }

    @Override
    public Category getById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryMapper.getAll(new Category());
    }

    @Override
    public ResBean getCountByCid(Integer cid) {
        return new ResBean(categoryArticleMapper.getCountByCid(cid));
    }

    @Override
    public ResBean deleteById(Integer id) {
        return new ResBean(categoryMapper.deleteByPrimaryKey(id));
    }
}
