package com.pujiang.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pujiang.blog.bean.User;
import com.pujiang.blog.mapper.UserMapper;
import com.pujiang.blog.service.UserService;
import com.pujiang.blog.util.ResBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll(new User());
    }

    @Override
    public ResBean getPage(int offset, int limit, User user) {
        int page = offset / limit + 1;
        /*执行分页插件 一定奥谢在一查询语句的上i行业，中间不能再用任何其他代码*/
        PageHelper.startPage(page,limit);//page当前页，limit每页条数
        List<User> list = userMapper.getAll(user);
        /*封装分页数据信息*/
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return new ResBean(list,pageInfo.getTotal());
    }

    @Override
    public ResBean deleteById(Integer id) {
        return new ResBean(userMapper.deleteByPrimaryKey(id));
    }
  @Override
    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
    @Override
    public ResBean saveInfo(User user) {
        if (user.getId()==null){
            return new ResBean(userMapper.insertSelective(user));
        }
        return new ResBean(userMapper.updateByPrimaryKeySelective(user));
    }

}
