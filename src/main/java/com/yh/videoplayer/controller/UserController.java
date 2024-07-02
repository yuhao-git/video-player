package com.yh.videoplayer.controller;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageParam;
import com.yh.videoplayer.exception.CustomException;
import com.yh.videoplayer.pojo.User;
import com.yh.videoplayer.service.UserService;
import com.yh.videoplayer.common.JwtTokenUtils;
import com.yh.videoplayer.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//@CrossOrigin // 允许跨域
@RestController
//@RequestMapping("/admin")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("/users")
    public Result<List<User>> users() {
        return Result.success(userService.getAllUser());
    }

    @PostMapping("/users/login")
    public Result<User> usersLogin(@RequestParam(value = "name",required = true) String name
            ,@RequestParam(value = "password",required = true) String password){
        // 账号密码不能为空
        if(StrUtil.isBlank(name) || StrUtil.isBlank(password)){
            throw new CustomException("账号或密码不能为空！");
        }
        User user = userService.getUserByNameAndPassword(name,password);
        // 账号或者密码错误
        if( user == null){
            throw new CustomException("账号或密码错误！");
        }

        // 登录成功 添加token id + 密码生成token
        String token = JwtTokenUtils.getToken(user.getId(),user.getPassword());
        user.setToken(token);
        return Result.success(user);
    }
    @PostMapping("/user")
    public Result<User> user(@RequestParam(value = "id",required = false) String id) {
        return Result.success(userService.getUserById(id));
//        return Result.fail("未知错误！");
    }

    // 模糊查询
    @PostMapping("/find/users")
    public Result<PageInfo<User>> findUsers(@RequestParam(value = "name",required = false) String name,
                                            @RequestParam(value = "age",required = false) Integer age,
                                            PageParam pageParam){
        PageInfo<User> info = userService.getUsersByNameAndAge(name,age,pageParam);
        return Result.success(info);
    }


    @PostMapping("/add/user")
    public Result<String> addUser(User user) {
        if(userService.getUserByName(user.getName()) != null ){
            throw new CustomException("当前用户已存在！");
        }
        userService.addUser(user);
        return Result.success("用户添加成功");
    }

//    @PostMapping("/user")
//    public Result<User> user(@RequestParam("id") String id) {
//        return Result.success(userService.getUserById(id));
//    }

//    @PostMapping("/user/{id}")
//    public Result<User> user(@PathVariable("id") String id) {
//        return Result.success(userService.getUserById(id));
//    }
}
