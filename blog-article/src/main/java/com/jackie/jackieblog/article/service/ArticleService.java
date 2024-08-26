package com.jackie.jackieblog.article.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.jackie.jackieblog.article.dao.ArticleServiceMapper;
import com.jackie.jackieblog.article.entity.Article;
import com.jackie.jackieblog.article.entity.SysUser;
import com.jackie.jackieblog.article.utils.PageParams;
import com.jackie.jackieblog.article.vo.ArticleVo;
import com.jackie.jackieblog.article.vo.UserVo;
import com.jackie.jackieblog.article.vo.WrapperToFrontend;
import com.jackie.jackieblog.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author:  Jackie Wang
 * @WechatId:  ilovepython12138
 * @GitHub: https://github.com/wangjm12138
 * @Blog: http://www.jackieblog.top
 * @Date: 2023年02月19日 19:59
 */
@Slf4j
@Service
public class ArticleService {
    @Value("${file.upload.protocol}")
    private String protocol;
    @Value("${server.port}")
    private String port;

    @Value("${server.address}")
    private String address;


    @Autowired
    private ArticleServiceMapper articleServiceMapper;


    @Autowired
    private TagService tagService;

    @Autowired
    private SysUserService sysUserService;

//    @Autowired
//    private StringRedisTemplate redisTemplate;
//    @Autowired
//    private StringRedisTemplate redisTemplate;


    public Result listArticleTop() {
        List<Article> records = articleServiceMapper.listArticleTop();
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record,false,false,false,false));
        }

        return Result.success(articleVoList);
    }

    public Result listArticleRecent() {
        List<Article> records = articleServiceMapper.listArticleRecent();
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record,false,false,false,false));
        }
        return Result.success(articleVoList);
    }

    public Result listArticle(PageParams pageParams) {
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        System.out.println("jackie");
        System.out.println("tagID: "+pageParams.getTagId()+" categoryID:"+ pageParams.getCategoryId());
        //System.out.println();
        IPage<Article> articleIPage = articleServiceMapper.listArticle(
                page,
                pageParams.getCategoryId(),
                pageParams.getTagId(),
                pageParams.getYear(),
                pageParams.getMonth());
        List<Article> records = articleIPage.getRecords();
        System.out.println(records.size());
//        for (Article record : records) {
//            String viewCount = (String) redisTemplate.opsForHash().get("view_count", String.valueOf(record.getId()));
//            if (viewCount != null) {
//                record.setViewCounts(Integer.parseInt(viewCount));
//            }
//        }
        List<ArticleVo> recordsVo = copyList(records,false,true);
        WrapperToFrontend wrapperRecordsVo = new WrapperToFrontend();
        wrapperRecordsVo.setPageNum(articleIPage.getCurrent());
        wrapperRecordsVo.setPages(articleIPage.getPages());
        wrapperRecordsVo.setPageSize(articleIPage.getSize());
        wrapperRecordsVo.setTotal(articleIPage.getTotal());
        if (articleIPage.getCurrent() == articleIPage.getPages()) {
            wrapperRecordsVo.setLast(true);
        } else {
            wrapperRecordsVo.setLast(false);
        }
        wrapperRecordsVo.setValue(recordsVo);
        return Result.success(wrapperRecordsVo);
    }


    private List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor) {

        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record,isTag,isAuthor,false,false));
        }
        return articleVoList;
    }

     private ArticleVo copy(Article article, boolean isTag, boolean isAuthor, boolean isBody,boolean isCategory) {

        ArticleVo articleVo = new ArticleVo();
        articleVo.setId(String.valueOf(article.getId()));
        BeanUtils.copyProperties(article,articleVo);

        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        articleVo.setCover(article.getCover());
        //并不是所有的接口 都需要标签 ，作者信息
        if (isTag){
            Long articleId = article.getId();
            articleVo.setTags(tagService.findTagsByArticleId(articleId));
        }

        if (isAuthor){

            Long authorId = article.getAuthorId();
            SysUser sysUser = sysUserService.findUserById(authorId);
            UserVo userVo = new UserVo();
            userVo.setAvatar(sysUser.getAvatar());
            userVo.setId(sysUser.getId().toString());
            userVo.setNickname(sysUser.getNickname());
            articleVo.setAuthor(userVo);
        }



//        if (isBody){
//            Long bodyId = article.getBodyId();
//            articleVo.setBody(findArticleBodyById(bodyId));
//        }
//        if (isCategory){
//            Long categoryId = article.getCategoryId();
//            articleVo.setCategory(categoryService.findCategoryById(categoryId));
//        }
        return articleVo;
    }

}

