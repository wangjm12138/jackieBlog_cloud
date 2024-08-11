package com.jackie.jackieblog.article.service;

import com.jackie.jackieblog.article.dao.ArticleBodyServiceMapper;
import com.jackie.jackieblog.article.entity.ArticleBody;
import com.jackie.jackieblog.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Jackie Wang
 * @WechatID: ilovepython12138
 * @GitHub: https://github.com/wangjm12138
 * @Blog: http://www.jackieblog.top
 * @Date: 2023年06月24日 12:30
 * @Description:
 */
@Service
public class ArticleBodyService {


    @Autowired
    private ArticleBodyServiceMapper articleBodyServiceMapper;



    public Result searchArticleById(String Id){

        ArticleBody records = articleBodyServiceMapper.selectById(Id);
        return Result.success(records);
    }
}
