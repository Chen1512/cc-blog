package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.User;
import com.sangeng.domain.vo.BlogUserLoginVo;
import com.sangeng.domain.vo.UserInfoVo;
import com.sangeng.service.BlogLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2023--07-13:50
 */
@RestController
@Api(tags = "登录接口")
public class BlogLoginController {
    @Autowired
    private BlogLoginService blogLoginService;

    /**
     * @Description:登录功能
     * @return: com.sangeng.domain.ResponseResult<com.sangeng.domain.vo.UserInfoVo>
     * @author: chen
     * @date: 2023/8/7 13:57
     */
    @PostMapping("/login")
    @ApiOperation("登录")
    public ResponseResult<BlogUserLoginVo> login(@RequestBody User user){
        BlogUserLoginVo blogUserLoginVo=blogLoginService.login(user);
        return ResponseResult.okResult(blogUserLoginVo);
    }

    /**
     * @Description:退出登录
     * @return: com.sangeng.domain.ResponseResult
     * @author: chen
     * @date: 2023/8/7 15:16
     */
    @PostMapping("/logout")
    @ApiOperation("退出登录")
    public ResponseResult logout(){
        blogLoginService.logout();
        return ResponseResult.okResult(200,"操作成功");
    }
}
