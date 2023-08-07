package com.sangeng.constants;

import com.sun.deploy.association.Action;

/**
 * @author shkstart
 * @create 2023--03-9:20
 */
public class SystemConstants {
    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;
    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    // 分类禁用状态
    public static final String CATEGORY_STATUS_DISABLED = "1";
    //分类正常状态
    public static final String CATEGORY_STATUS_NORMAL = "0";

    // 审核通过
    public static final String LINK_STATUS_PASS = "0";
    //审核未通过
    public static final String LINK_STATUS_DISOASS = "1";
    //待审核
    public static final String LINK_STATUS_TO_BE_REVIEWED = "2";

}
