package com.pujiang.blog.controller.admin;

import com.pujiang.blog.bean.Category;
import com.pujiang.blog.service.CategoryService;
import com.pujiang.blog.util.ResBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/getPage")
    public ResBean getPage(int offset, int limit, Category category){
        return categoryService.getPage(offset,limit,category);
    }


    @RequestMapping("/saveInfo")
    public ResBean saveInfo(Category category){
        return categoryService.saveInfo(category);
    }

    @RequestMapping("/getById")
    public Category getById(Integer id){
        System.out.println(id);
        return categoryService.getById(id);
    }

    @RequestMapping("/getAll")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @RequestMapping("/getCountByCid")
    public ResBean getCountByCid(Integer cid){
        return categoryService.getCountByCid(cid);
    }
    @RequestMapping("/delete")
    public ResBean deleteById(Integer id){
        return categoryService.deleteById(id);
    }
}
