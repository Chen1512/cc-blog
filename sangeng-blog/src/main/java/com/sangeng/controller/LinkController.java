package com.sangeng.controller;



import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.vo.LinkVo;
import com.sangeng.service.LinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 友链(Link)表控制层
 *
 * @author makejava
 * @since 2023-08-03 19:29:19
 */
@RestController
@RequestMapping("/link")
@Api(tags = "友链(Link)表控制层")
public class LinkController {
    /**
     * 服务对象
     */
    @Resource
    private LinkService linkService;

    /**
     * @Description:查询出所有的审核通过的友链
     * @return: com.sangeng.domain.ResponseResult<com.sangeng.domain.vo.LinkVo>
     * @author: chen
     * @date: 2023/8/3 19:32
     */
    @ApiOperation("查询出所有的审核通过的友链")
    @GetMapping("/getAllLink")
    public ResponseResult<List<LinkVo>> getAllLink(){
        List<LinkVo> linkVos = linkService.getAllLink();
        return ResponseResult.okResult(linkVos);
    }
}

