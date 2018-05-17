/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl;

import com.seed.shopping.bean.ArticleDataManager;
import com.seed.shopping.model.Article;
import com.seed.shopping.service.impl.logic.AbstractArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Service
public class ArticleServiceImpl extends AbstractArticleService {

    @Autowired
    private ArticleDataManager articleDataManager;

    @Override
    public List<Article> findByName(String name) {
        return articleDataManager.findByName(name);
    }

    @Override
    public List<Article> findAll() {
        return articleDataManager.findAll();
    }

    @Override
    public void edit(Article article) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Article article) {
        article.setRemainingQuantity(0);
        articleDataManager.create(article);
    }

    @Override
    public Article findById(Integer articleId) {
        return articleDataManager.findById(articleId);
    }

}
