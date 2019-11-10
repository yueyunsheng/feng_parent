package com.feng.search.dao;

import com.feng.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleDao extends ElasticsearchRepository<Article,String> {

     Page<Article> findByTitleOrContent(String title, String content, Pageable pageable);
}
