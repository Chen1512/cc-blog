package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.entity.Link;
import com.sangeng.domain.vo.LinkVo;

import java.util.List;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2023-08-03 19:28:59
 */
public interface LinkService extends IService<Link> {

    /**
     * @Description:友链(Link)表控制层
     * @return: com.sangeng.domain.vo.LinkVo
     * @author: chen
     * @date: 2023/8/3 19:32
     */
    List<LinkVo> getAllLink();
}
