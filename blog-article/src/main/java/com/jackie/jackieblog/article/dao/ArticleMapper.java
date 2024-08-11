package com.jackie.jackieblog.article.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jackie.jackieblog.article.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jackie
 * @since 2024-07-28
 */
public interface ArticleMapper extends BaseMapper<Article> {

    IPage<Article> listArticle(Page<Article> page,
                               Long categoryId,
                               Long tagId,
                               String year,
                               String month);

    List<Article> listArticleTop();

    List<Article> listArticleRecent();

}
