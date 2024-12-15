package com.jackie.jackieblog.article.dao;

import com.jackie.jackieblog.article.entity.Category;
import com.jackie.jackieblog.article.entity.CategoryDetails;
import com.jackie.jackieblog.article.entity.Menu;

import java.util.List;

public interface CategoryServiceMapper {
//    List<Category> listCategoryAllById(Integer CategoryId);
//
//    List<CategoryDetails> listDetailsByCategoryId(Integer CategoryId);

    Category listCategoryById(Integer CategoryId);


    CategoryDetails listCategoryDetailsById(Integer CategoryDetailsId);

    List<CategoryDetails> listDetailsByCategoryId(Integer CategoryId);
}
