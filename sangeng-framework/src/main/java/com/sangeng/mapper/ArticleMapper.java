package com.sangeng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sangeng.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;


/**
 * 文章表(Article)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-02 17:13:29
 */
@Mapper
public interface ArticleMapper  extends BaseMapper<Article> {

}

