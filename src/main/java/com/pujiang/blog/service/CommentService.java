package com.pujiang.blog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.pujiang.blog.bean.Comment;
import com.pujiang.blog.util.ResBean;

public interface CommentService {
    ResBean updateComment(Comment comment);
    ResBean deleteComment(Integer id);
    ResBean getPage(int offset,int limit,Comment comment);
    PageInfo<Comment> getCommentList(int page,int limit);
    Comment getById(Integer id);

}
