package com.yh.videoplayer.mapper;

import com.yh.videoplayer.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {
     List<User> getAllUser();

//    @Select("select id, name, age from user where name like concat('%',#{name},'%') and age > #{age}" )
     List<User> getUsersByNameAndAge(@Param("name") String name,@Param("age") Integer age);
    @Select("select id, name, age,password from user where id = #{id}")
     User getUserById(String id);

    @Select("select id, name, age from user where name = #{name} limit 1")
    User getUserByName(String name);
    @Insert("insert into user(id,name,age,password) values(#{id},#{name},#{age},#{password})")
     void addUser(User user);
    @Update("update user set name=#{name},age=#{age} where id=#{id}")
     void updateUser(User user);
    @Delete("delete from user where id=#{id}")
     void deleteUser(String id);
    @Select("select id, name, age, password from user where name = #{name} and password = #{password}")
    User getUserByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
