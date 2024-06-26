package com.yh.videoplayer.service;


import com.yh.videoplayer.pojo.User;

import java.util.List;
public interface UserService {
    public List<User> getAllUser();
    public List<User> getUserByName(String name,Integer age);

    public User getUserById(String id);

    void addUser(User user);
}
