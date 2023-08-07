package com.sangeng.service;

import com.sangeng.domain.entity.User;
import com.sangeng.domain.vo.BlogUserLoginVo;
import com.sangeng.domain.vo.UserInfoVo;

/**
 * @author shkstart
 * @create 2023--07-13:53
 */
public interface BlogLoginService {
    /**
     * @Description:登录功能
     * @return: com.sangeng.domain.vo.UserInfoVo
     * @author: chen
     * @date: 2023/8/7 13:57
     */
    BlogUserLoginVo login(User user);

    /**
     * @Description:退出登录
     * @return: void
     * @author: chen
     * @date: 2023/8/7 15:16
     */
    void logout();

}
