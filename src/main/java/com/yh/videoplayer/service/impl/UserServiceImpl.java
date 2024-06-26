package com.yh.videoplayer.service.impl;

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
    public List<User> getUserByName(String name,Integer age) {
        return userMapper.getUsersByName(name,age);
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
