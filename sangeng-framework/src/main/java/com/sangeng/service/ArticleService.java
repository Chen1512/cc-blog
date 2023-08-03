package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.Article;
import com.sangeng.domain.vo.ArticleDetailVo;
import com.sangeng.domain.vo.PageVo;


/**
 * 文章表(Article)表服务接口
 *
 * @author makejava
 * @since 2023-08-02 16:46:41
 */
public interface ArticleService extends IService<Article> {

    /**
     * @Description:热门文章列表
     * @return: com.sangeng.domain.ResponseResult
     * @author: chen
     * @date: 2023/8/3 9:27
     */
    ResponseResult hotArticleList();

    /**
     * @Description:分页查询文章列表
     * @return: com.sangeng.domain.vo.PageVo
     * @author: chen
     * @date: 2023/8/3 15:26
     */
    PageVo articleList(Integer pageNum, Integer pageSize, Long categoryId);

    /**
     * @Description:查看文章详情
     * @return: com.sangeng.domain.vo.ArticleDetailVo
     * @author: chen
     * @date: 2023/8/3 18:59
     */
    ArticleDetailVo getArticleDetail(Long id);
}

