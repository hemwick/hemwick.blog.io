package com.pujiang.blog.service;

import com.pujiang.blog.bean.User;
import com.pujiang.blog.util.ResBean;

import java.util.List;

public interface UserService {
    User login(User user);
    List<User> getAll();
    ResBean getPage(int offset, int limit, User user);
    ResBean deleteById(Integer id);
    User getById(Integer id);
    ResBean saveInfo(User user);

}
