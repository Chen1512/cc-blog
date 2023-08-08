package com.sangeng.controller;



import com.sangeng.service.UserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2023-08-08 08:46:33
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

  
}

