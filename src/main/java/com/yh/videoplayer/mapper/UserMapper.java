package com.yh.videoplayer.mapper;

import com.yh.videoplayer.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {
    public List<User> getAllUser();

//    @Select("select id, name, age from user where name like concat('%',#{name},'%') and age > #{age}" )
    public List<User> getUsersByNameAndAge(@Param("name") String name,@Param("age") Integer age);
    @Select("select id, name, age from user where id = #{id}")
    public User getUserById(String id);
    @Insert("insert into user(id,name,age) values(#{id},#{name},#{age})")
    public void addUser(User user);
    @Update("update user set name=#{name},age=#{age} where id=#{id}")
    public void updateUser(User user);
    @Delete("delete from user where id=#{id}")
    public void deleteUser(String id);
}
