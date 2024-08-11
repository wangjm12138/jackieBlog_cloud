package com.jackie.jackieblog.article.entity;

import lombok.Data;


/**
 * @Author:  Jackie Wang
 * @WechatId:  ilovepython12138
 * @GitHub: https://github.com/wangjm12138
 * @Blog: http://www.jackieblog.top
 * @Date: 2023年02月19日 21:59
 */
@Data
public class Article {

    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

    private Long id;

    /**
     * 创建时间
     */
    private Long createDate;


    private String title;

    private String summary;

    private Integer commentNum;

    private Integer lookNum;

    private Integer loveNum;


    /**
     * 置顶
     */
    private Integer weight;

    /**
     * 内容id
     */
    private Long bodyId;
    /**
     *类别id
     */

    private Long categoryId;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * cover
     */
    private String cover;
}