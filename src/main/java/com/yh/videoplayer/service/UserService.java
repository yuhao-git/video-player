package com.yh.videoplayer.service;


import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageParam;
import com.yh.videoplayer.pojo.User;

import java.util.List;
public interface UserService {
     List<User> getAllUser();
     PageInfo<User> getUsersByNameAndAge(String name, Integer age, PageParam pageParam);

     User getUserById(String id);

     User getUserByName(String name);

     User getUserByNameAndPassword(String name,String password);

     void addUser(User user);

}
