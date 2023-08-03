package com.sangeng.controller;



import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.vo.CategoryVo;
import com.sangeng.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 分类表(Category)表控制层
 *
 * @author makejava
 * @since 2023-08-03 14:32:54
 */
@RestController
@RequestMapping("/category")
@Api(tags = "分类表(Category)表控制层")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    /**
     * @Description:查询分类列表
     * @return: com.sangeng.domain.ResponseResult
     * @author: chen
     * @date: 2023/8/3 14:35
     */
    @GetMapping("/getCategoryList")
    @ApiOperation("查询分类列表")
    public ResponseResult<List<CategoryVo>> getCategoryList(){
        List<CategoryVo> categoryVo=categoryService.getCategoryList();
        return ResponseResult.okResult(categoryVo);
    }

  
}

