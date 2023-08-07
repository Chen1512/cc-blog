package com.sangeng.controller;



import com.sangeng.service.SgCommentService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 评论表(SgComment)表控制层
 *
 * @author makejava
 * @since 2023-08-07 16:29:11
 */
@RestController
@RequestMapping("/sgComment")
public class SgCommentController {
    /**
     * 服务对象
     */
    @Resource
    private SgCommentService sgCommentService;

  
}

