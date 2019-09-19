package com.pujiang.blog.controller.admin;

import com.pujiang.blog.bean.Comment;
import com.pujiang.blog.service.CommentService;
import com.pujiang.blog.util.ResBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/admin/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/getPage")
    public ResBean getPage(int offset,int limit,Comment comment){
        return commentService.getPage(offset,limit,comment);
    }

    @RequestMapping("/update")
    public ResBean updateStatus(Comment comment){
        return commentService.updateComment(comment);
    }
    @RequestMapping("/delete")
    public ResBean deleteComment(Integer id){
        return commentService.deleteComment(id);
    }

    @RequestMapping("/getById")
    public Comment getById(Integer id){
        return commentService.getById(id);
    }
}
