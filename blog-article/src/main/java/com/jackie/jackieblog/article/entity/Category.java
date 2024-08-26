package com.jackie.jackieblog.article.entity;

import lombok.Data;

/**
 * @Author: Jackie Wang
 * @WechatID: ilovepython12138
 * @GitHub: https://github.com/wangjm12138
 * @Blog: http://www.jackieblog.top
 * @Date: 2023年06月23日 18:05
 * @Description:
 */
@Data
public class Category {

    private Long id;

    private String avatar;

    private String categoryName;

    private String description;

    private Integer amount;
//
//    private String name;
}
