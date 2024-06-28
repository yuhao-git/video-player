package com.yh.videoplayer.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageParam;
import com.yh.videoplayer.pojo.User;
import com.yh.videoplayer.service.UserService;
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


//    @PostMapping("/user")
//    public Result<User> user(@RequestParam("id") String id) {
//        return Result.success(userService.getUserById(id));
//    }

//    @PostMapping("/user/{id}")
//    public Result<User> user(@PathVariable("id") String id) {
//        return Result.success(userService.getUserById(id));
//    }
}
