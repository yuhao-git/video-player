package com.yh.videoplayer.mapper;

import com.yh.videoplayer.dao.User;
import com.yh.videoplayer.dto.UserDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {
     List<User> getAllUser();

//    @Select("select id, username, age from user where username like concat('%',#{username},'%') and age > #{age}" )
     List<UserDTO> getUsersByNameAndAge(@Param("username") String username, @Param("age") Integer age);
    @Select("select id, username, age,password from user where id = #{id}")
     User getUserById(String id);

    @Select("select id, username, age from user where username = #{username} limit 1")
    User getUserByName(String username);
    @Insert("insert into user(id,username,age,password) values(#{id},#{username},#{age},#{password})")
     void addUser(User user);
    @Update("update user set username=#{username},age=#{age} where id=#{id}")
     void updateUser(User user);
    @Delete("delete from user where id=#{id}")
     void deleteUser(String id);
    @Select("select id, username, age, password from user where username = #{username} and password = #{password}")
    User getUserByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
