package com.sangeng.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author shkstart
 * @create 2023--03-18:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailVo {
    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //所属分类id
    private Long categoryId;
    //所属分类名
    private String categoryName;
    //创建时间
    private Date createTime;
    //是否允许评论 1是，0否
    private String isComment;
    //访问量
    private Long viewCount;
}
