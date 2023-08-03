package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.entity.Category;
import com.sangeng.domain.vo.CategoryVo;

import java.util.List;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2023-08-03 14:33:07
 */
public interface CategoryService extends IService<Category> {

    /**
     * @Description:查询分类列表
     * @return: com.sangeng.domain.vo.CategoryVo
     * @author: chen
     * @date: 2023/8/3 14:39
     */
    List<CategoryVo> getCategoryList();
}
