package com.pujiang.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pujiang.blog.bean.Comment;
import com.pujiang.blog.mapper.CommentMapper;
import com.pujiang.blog.service.CommentService;
import com.pujiang.blog.util.MyUtil;
import com.pujiang.blog.util.ResBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ResBean updateComment(Comment comment) {
        if (comment.getId() == null) {
            comment.setCreated(MyUtil.nowDate());/*获取时间尽量不要在js里拿*/
            return new ResBean(commentMapper.insertSelective(comment));
        }
        return new ResBean(commentMapper.updateByPrimaryKeySelective(comment));
    }

    @Override
    public ResBean deleteComment(Integer id) {
        return new ResBean(commentMapper.deleteByPrimaryKey(id));
    }

    @Override
    public ResBean getPage(int offset, int limit, Comment comment) {
        int page = offset/limit+1;
        PageHelper.startPage(page,limit);
        List<Comment> list = commentMapper.getAll(comment);
        PageInfo<Comment> pageInfo = new PageInfo<>(list);
        return new ResBean(list,pageInfo.getTotal());
    }

    @Override
    public PageInfo<Comment> getCommentList(int page, int limit) {
        Comment comment = new Comment();
        comment.setStatus(2);
        PageHelper.startPage(page,limit);
        List<Comment> list = commentMapper.getAll(comment);
        return  new PageInfo<>(list);
    }

    @Override
    public Comment getById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }
}
