package com.yh.videoplayer.service;


import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageParam;
import com.yh.videoplayer.pojo.User;

import java.util.List;
public interface UserService {
    public List<User> getAllUser();
    public PageInfo<User> getUsersByNameAndAge(String name, Integer age, PageParam pageParam);

    public User getUserById(String id);

    void addUser(User user);

}
