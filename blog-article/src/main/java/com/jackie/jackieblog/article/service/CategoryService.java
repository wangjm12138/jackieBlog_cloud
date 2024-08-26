package com.jackie.jackieblog.article.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jackie.jackieblog.article.dao.CategoryServiceMapper;
import com.jackie.jackieblog.article.entity.Category;
import com.jackie.jackieblog.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Jackie Wang
 * @WechatID: ilovepython12138
 * @GitHub: https://github.com/wangjm12138
 * @Blog: http://www.jackieblog.top
 * @Date: 2023年06月23日 18:02
 * @Description:
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryServiceMapper categoryServiceMapper;


    public Result listCategory() {
        QueryWrapper queryWrapper= new QueryWrapper<>();
        queryWrapper.orderByDesc("amount");

        List<Category> records = categoryServiceMapper.selectList(queryWrapper);
        return Result.success(records);
    }


}
