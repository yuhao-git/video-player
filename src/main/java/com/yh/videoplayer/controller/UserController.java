package com.yh.videoplayer.controller;

import com.yh.videoplayer.pojo.User;
import com.yh.videoplayer.service.UserService;
import com.yh.videoplayer.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/user")
    public Result<User> user(@RequestParam(value = "id",required = false) String id) {
        return Result.success(userService.getUserById(id));
//        return Result.fail("未知错误！");
    }

    @PostMapping("/add/user")
    public Result<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return Result.success("添加成功");
    }

    // 模糊查询
    @PostMapping("/find/users")
    public Result<List<User>> findUsers(@RequestParam(value = "name",required = false) String name,
                                        @RequestParam(value = "age",required = false) Integer age){
        return Result.success(userService.getUserByName(name,age));
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
