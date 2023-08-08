package com.sangeng.controller;



import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.User;
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
//oss-cn-beijing.aliyuncs.com
//LTAI5tPCUkfzLPtMVhbbJriv
//RoTFtxsRfLWSrz1hbz4sXuJEIrOYX6
//cc-flbk-img
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

    /**
     * @Description:更新个人信息接口
     * @return: com.sangeng.domain.ResponseResult
     * @author: chen
     * @date: 2023/8/8 11:05
     */
    @ApiOperation("更新个人信息接口")
    @PutMapping("/userInfo")
    public ResponseResult updateUserInfo(@RequestBody User user){
        userService.updateUserInfo(user);
        return ResponseResult.okResult();
    }


}

