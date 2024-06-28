package com.yh.videoplayer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageParam;
import com.yh.videoplayer.mapper.UserMapper;
import com.yh.videoplayer.pojo.User;
import com.yh.videoplayer.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public PageInfo<User> getUsersByNameAndAge(String name, Integer age, PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        List<User> list = userMapper.getUsersByNameAndAge(name,age);
        return PageInfo.of(list);
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

}
