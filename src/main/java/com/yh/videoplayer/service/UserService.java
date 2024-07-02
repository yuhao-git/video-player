package com.yh.videoplayer.service;


import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageParam;
import com.yh.videoplayer.dao.User;
import com.yh.videoplayer.dto.UserDTO;

import java.util.List;
public interface UserService {
     List<User> getAllUser();
     PageInfo<UserDTO> getUsersByNameAndAge(String username, Integer age, PageParam pageParam);

     User getUserById(String id);

     User getUserByName(String username);

     User getUserByNameAndPassword(String username,String password);

     void addUser(User user);

}
