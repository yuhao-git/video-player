package com.yh.videoplayer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageParam;
import com.yh.videoplayer.dto.UserDTO;
import com.yh.videoplayer.mapper.UserMapper;
import com.yh.videoplayer.dao.User;
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
    public PageInfo<UserDTO> getUsersByNameAndAge(String username, Integer age, PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        List<UserDTO> list = userMapper.getUsersByNameAndAge(username,age);
        return PageInfo.of(list);
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public User getUserByNameAndPassword(String username, String password) {
        return userMapper.getUserByNameAndPassword(username,password);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }



}
