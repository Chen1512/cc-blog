package com.sangeng.controller;



import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.vo.UserInfoVo;
import com.sangeng.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "用户功能代码")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @GetMapping("/userInfo")
    @ApiOperation("个人信息查询接口")
    public ResponseResult<UserInfoVo> userInfo(){
        UserInfoVo userInfoVo = userService.userInfo();
        return ResponseResult.okResult(userInfoVo);
    }


}

