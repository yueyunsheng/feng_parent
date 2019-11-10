package com.feng.search.controller;

import com.feng.search.pojo.Article;
import com.feng.search.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pojo.PageResult;
import pojo.Result;
import pojo.StatusCode;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody Article article){
        articleService.save(article);
        return new Result(true, StatusCode.OK,"添加成功！");
    }

    @RequestMapping(value = "/{key}/{page}/{size}",method = RequestMethod.GET)
    public Result findByKey(@PathVariable String key,@PathVariable int page,
                             @PathVariable int size){
        Page<Article> pageData = articleService.findByKey(key, 1, 1);
        return new Result(true,StatusCode.OK,"查询成功",
                new PageResult<Article>(pageData.getTotalElements(),pageData.getContent()));
    }

}
