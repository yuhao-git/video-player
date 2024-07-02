package com.yh.videoplayer.converter;

import com.yh.videoplayer.dao.User;
import com.yh.videoplayer.dto.UserDTO;

public class UserConverter {

    // 用户转换器
    public static UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(user.getAge());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }
}
