package com.sangeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.constants.SystemConstants;
import com.sangeng.domain.entity.Comment;
import com.sangeng.domain.vo.CommentVo;
import com.sangeng.domain.vo.PageVo;
import com.sangeng.enums.AppHttpCodeEnum;
import com.sangeng.exception.SystemException;
import com.sangeng.mapper.CommentMapper;
import com.sangeng.service.CommentService;
import com.sangeng.service.UserService;
import com.sangeng.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author makejava
 * @since 2023-08-07 16:38:17
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private UserService userService;

    /**
     * @Description:查询评论列表
     * @return: com.sangeng.domain.vo.CommentVo
     * @author: chen
     * @date: 2023/8/7 16:48
     */
    @Override
    public PageVo commentList(String commentType,Long articleId, Integer pageNum, Integer pageSize) {
        //分页查询该博客下的根评论
        //创建查询条件：articleId=articleId，RootId=-1
        LambdaQueryWrapper<Comment> commentWrapper = new LambdaQueryWrapper<>();
        commentWrapper.eq(SystemConstants.ARTICLE_COMMENT.equals(commentType),Comment::getArticleId,articleId);
        commentWrapper.eq(Comment::getRootId,-1);
        commentWrapper.eq(Comment::getType,commentType);
        Page<Comment> page = new Page<>(pageNum, pageSize);
        page(page, commentWrapper);
        //把评论封装未vo对象并补齐其中没有赋值的属性
        List<CommentVo> commentVoList = toCommentVoList(page.getRecords());
        //遍历根评论
        for (CommentVo commentVo : commentVoList) {
            //查询每条根评论下的子评论
            List<CommentVo> children = getChildren(commentVo.getId());
            //赋值
            commentVo.setChildren(children);
        }
        return new PageVo(page.getTotal(),commentVoList);
    }

    /**
     * @Description:发表评论接口
     * @return: void
     * @author: chen
     * @date: 2023/8/7 19:45
     */
    @Override
    public void addComment(Comment comment) {
        if (!StringUtils.hasText(comment.getContent())){
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }
        save(comment);
    }

    private List<CommentVo> getChildren(Long id) {
        LambdaQueryWrapper<Comment> commentWrapper = new LambdaQueryWrapper<>();
        commentWrapper.eq(Comment::getRootId,id);
        commentWrapper.orderByAsc(Comment::getCreateTime);
        List<Comment> comments = list(commentWrapper);
        //把子评论封装为vo对象并补齐其中没有赋值的属性
        List<CommentVo> commentVos = toCommentVoList(comments);
        return commentVos;
    }

    private List<CommentVo> toCommentVoList(List<Comment> list) {
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(list, CommentVo.class);
        for (CommentVo commentVo : commentVos) {
            String nickName = userService.getById(commentVo.getCreateBy()).getNickName();
            commentVo.setUsername(nickName);
            if (commentVo.getToCommentUserId()!=-1){
                String toCommentUserName = userService.getById(commentVo.getToCommentUserId()).getNickName();
                commentVo.setToCommentUserName(toCommentUserName);
            }
        }
        return commentVos;
    }
}
