package com.jackie.jackieblog.article.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jackie.jackieblog.article.entity.Article;

import java.util.List;

public interface ArticleServiceMapper extends BaseMapper<Article> {
    //Article listArticle(Long id, Long categoryID, Long tagID, String year, String month);


    IPage<Article> listArticle(Page<Article> page,
                               Long categoryId,
                               Long tagId,
                               String year,
                               String month);

    List<Article> listArticleTop();

    List<Article> listArticleRecent();
}