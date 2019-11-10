package com.feng.search.service;

import com.feng.search.dao.ArticleDao;
import com.feng.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public void save(Article article){
        articleDao.save(article);
    }

    public Page<Article> findByKey(String key,int page,int size){
        Pageable pageable = PageRequest.of(page-1,size);
        return articleDao.findByTitleOrContent(key,key,pageable);
    }

}
