package com.sangeng.controller;


import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.vo.ArticleDetailVo;
import com.sangeng.domain.vo.PageVo;
import com.sangeng.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import sun.net.idn.Punycode;

import javax.annotation.Resource;
import javax.crypto.interfaces.PBEKey;

/**
 * 文章表(Article)表控制层
 *
 * @author makejava
 * @since 2023-08-02 16:35:34
 */
@RestController
@RequestMapping("/article")
@Api(tags = "文章表(Article)表控制")
public class ArticleController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

    /**
     * @Description:热门文章列表
     * @return: com.sangeng.domain.ResponseResult
     * @author: chen
     * @date: 2023/8/3 9:27
     */
    @GetMapping("/hotArticleList")
    @ApiOperation("热门文章列表")
    public ResponseResult hotArticleList(){

        ResponseResult result =  articleService.hotArticleList();
        return result;
    }


    /**
     * @Description:分页查询文章列表
     * @return: com.sangeng.domain.ResponseResult
     * @author: chen
     * @date: 2023/8/3 15:20
     */
    @ApiOperation("查询文章列表")
    @GetMapping("/articleList")
    public ResponseResult<PageVo> articleList(Integer pageNum, Integer pageSize, Long categoryId){
        PageVo pageVo = articleService.articleList(pageNum,pageSize,categoryId);
        return ResponseResult.okResult(pageVo);
    }

    /**
     * @Description:查看文章详情
     * @return: com.sangeng.domain.ResponseResult
     * @author: chen
     * @date: 2023/8/3 18:53
     */
    @GetMapping("/{id}")
    @ApiOperation("查看文章详情")
    public ResponseResult<ArticleDetailVo> getArticleDetail(@PathVariable Long id){
        ArticleDetailVo articleDetailVo=articleService.getArticleDetail(id);
        return ResponseResult.okResult(articleDetailVo);
    }

  
}

