/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl;

import com.seed.shopping.model.Article;
import com.seed.shopping.service.contract.ArticleService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Service
@Primary
public class ArticleRestService implements ArticleService {

    private static final Logger LOG = LoggerFactory.getLogger(ArticleRestService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${seed.shopping.rest.article.url}")
    private String articleUrl;

    @Override
    public Article findById(Integer articleId) {
        return restTemplate.getForObject(articleUrl + "/" + articleId, Article.class);
    }

    @Override
    public List<Article> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Article> getAllArticles() {
        List<Article> result = new ArrayList<>();
        try {
            Article[] response = restTemplate.getForObject(articleUrl, Article[].class);
            result.addAll(Arrays.asList(response));
        } catch (RestClientException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public void addArticle(Article article) {
        Article response = restTemplate.postForObject(articleUrl, article, Article.class);
        if (response != null) {
            article.setId(response.getId());
        }
    }

    @Override
    public Integer addToStock(Integer articleId, Integer addedValue) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer subFromStock(Integer articleId, Integer addedValue) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
