package com.sangeng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sangeng.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-06 20:45:24
 */
@Mapper
public interface UserMapper  extends BaseMapper<User> {

}

