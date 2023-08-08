package com.sangeng.controller;



import com.sangeng.constants.SystemConstants;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.Comment;
import com.sangeng.domain.vo.CommentVo;
import com.sangeng.domain.vo.PageVo;
import com.sangeng.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表(Comment)表控制层
 *
 * @author makejava
 * @since 2023-08-07 16:38:01
 */
@RestController
@RequestMapping("/comment")
@Api(tags = "评论相关功能")
public class CommentController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;

    /**
     * @Description:查询评论列表
     * @return: com.sangeng.domain.ResponseResult<com.sangeng.domain.vo.CommentVo>
     * @author: chen
     * @date: 2023/8/7 16:45
     */
    @GetMapping("/commentList")
    @ApiOperation("查询评论列表")
    public ResponseResult<PageVo> commentList(Long articleId, Integer pageNum, Integer pageSize){
        PageVo commentVos = commentService.commentList(SystemConstants.ARTICLE_COMMENT,articleId,pageNum,pageSize);
        return ResponseResult.okResult(commentVos);
    }

    /**
     * @Description:发表评论接口
     * @return: com.sangeng.domain.ResponseResult
     * @author: chen
     * @date: 2023/8/7 19:43
     */
    @PostMapping
    @ApiOperation("发表评论接口")
    public ResponseResult addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return ResponseResult.okResult();
    }

    /**
     * @Description:查询友链评论列表
     * @return: com.sangeng.domain.ResponseResult<com.sangeng.domain.vo.PageVo>
     * @author: chen
     * @date: 2023/8/7 23:39
     */
    @ApiOperation("查询友链评论列表")
    @GetMapping("/linkCommentList")
    public ResponseResult<PageVo> linkCommentList(Integer pageNum, Integer pageSize){
        PageVo pageVo = commentService.commentList(SystemConstants.LINK_COMMENT,null,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }
}

