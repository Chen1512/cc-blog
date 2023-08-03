package com.sangeng.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--03-15:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo {
    private Long total;
    private List rows;
}
