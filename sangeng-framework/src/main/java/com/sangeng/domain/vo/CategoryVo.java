package com.sangeng.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shkstart
 * @create 2023--03-14:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVo {
    //分类Id
    private Long id;
    //分类名
    private String name;
}
