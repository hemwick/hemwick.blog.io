package com.pujiang.blog.service;

import com.pujiang.blog.bean.Category;
import com.pujiang.blog.util.ResBean;

import java.util.List;

public interface CategoryService {
    ResBean getPage(int offset, int limit, Category category);
    ResBean saveInfo(Category category);
    Category getById(Integer id);
    List<Category> getAll();
    ResBean getCountByCid(Integer cid);
    ResBean deleteById(Integer id);
}
