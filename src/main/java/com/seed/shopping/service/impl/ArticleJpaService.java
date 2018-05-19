/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl;

import com.seed.shopping.model.Article;
import com.seed.shopping.repo.ArticleRepository;
import com.seed.shopping.service.impl.logic.AbstractArticleService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Service
public class ArticleJpaService extends AbstractArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public void edit(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void create(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Article findById(Integer articleId) {
        Optional<Article> findById = articleRepository.findById(articleId);
        return findById.isPresent() ? findById.get() : null;
    }

    @Override
    public List<Article> findByName(String name) {
        return articleRepository.findByName(name);
    }

}
