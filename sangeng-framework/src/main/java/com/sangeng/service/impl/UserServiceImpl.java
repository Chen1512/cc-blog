package com.sangeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.domain.entity.LoginUser;
import com.sangeng.domain.entity.User;
import com.sangeng.domain.vo.UserInfoVo;
import com.sangeng.mapper.UserMapper;

import com.sangeng.service.UserService;
import com.sangeng.utils.BeanCopyUtils;
import com.sangeng.utils.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-08-07 19:22:40
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * @Description:个人信息查询接口
     * @return: com.sangeng.domain.vo.UserInfoVo
     * @author: chen
     * @date: 2023/8/8 9:01
     */
    @Override
    public UserInfoVo userInfo() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        User user = loginUser.getUser();
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
        return userInfoVo;
    }
}

