package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.entity.Comment;
import com.sangeng.domain.vo.CommentVo;
import com.sangeng.domain.vo.PageVo;

import java.util.List;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2023-08-07 16:38:17
 */
public interface CommentService extends IService<Comment> {

    /**
     * @Description:查询评论列表
     * @return: com.sangeng.domain.vo.CommentVo
     * @author: chen
     * @date: 2023/8/7 16:48
     */
    PageVo commentList(String commentType,Long articleId, Integer pageNum, Integer pageSize);

    /**
     * @Description:发表评论接口
     * @return: void
     * @author: chen
     * @date: 2023/8/7 19:44
     */
    void addComment(Comment comment);

}
