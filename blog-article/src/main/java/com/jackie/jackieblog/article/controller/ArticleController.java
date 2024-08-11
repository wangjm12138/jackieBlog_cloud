package com.jackie.jackieblog.article.controller;

import com.jackie.jackieblog.article.service.ArticleService;
import com.jackie.jackieblog.article.utils.PageParams;
import com.jackie.jackieblog.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author:  Jackie Wang
 * @WechatId:  ilovepython12138
 * @GitHub: https://github.com/wangjm12138
 * @Blog: http://www.jackieblog.top
 * @Date: 2023年02月19日 15:28
 */
@RestController
@RequestMapping("api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    /**
     * 首页 文章列表
     * @param
     * @return
     */
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams){
//        try {
//            Thread.sleep(3000); // 1000毫秒 = 1秒
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return articleService.listArticle(pageParams);
    }
    @GetMapping("/test")
    public Result listArticleTop() {

        return Result.success("successful");
    }


//    @GetMapping("/top3")
//    public Result listArticleTop() {
//
////        System.out.println(Id);
////        try {
////            Thread.sleep(10000);//毫秒数
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        Result a = articleService.listArticleTop();
//        System.out.println(a);
//        return a;
//    }


//    @GetMapping("/recent")
//    public Result listArticleRecent() {
//
//        return articleService.listArticleRecent();
//    }
//
//    @Autowired
//    private ArticleBodyService articleBodyService;
//
//    @GetMapping("/detail/{Id}")
//    public Result listArticleDetail(@PathVariable("Id") String Id) {
//
////        System.out.println(Id);
//
//        return articleBodyService.searchArticleById(Id);
//    }


}
