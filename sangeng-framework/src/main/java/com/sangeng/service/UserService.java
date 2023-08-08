package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.entity.User;
import com.sangeng.domain.vo.UserInfoVo;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2023-08-07 19:22:40
 */
public interface UserService extends IService<User> {

    /**
     * @Description:个人信息查询接口
     * @return: com.sangeng.domain.vo.UserInfoVo
     * @author: chen
     * @date: 2023/8/8 9:01
     */
    UserInfoVo userInfo();

    /**
     * @Description:更新个人信息接口
     * @return: void
     * @author: chen
     * @date: 2023/8/8 11:06
     */
    void updateUserInfo(User user);

    /**
     * @Description:用户注册
     * @return: void
     * @author: chen
     * @date: 2023/8/8 11:12
     */
    void register(User user);
}

