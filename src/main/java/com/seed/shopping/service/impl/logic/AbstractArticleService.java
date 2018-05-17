/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl.logic;

import com.seed.shopping.model.Article;
import com.seed.shopping.service.contract.ArticleService;
import java.util.List;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public abstract class AbstractArticleService implements ArticleService {

    public abstract List<Article> findAll();
    
    public abstract void edit(Article article);

    public abstract void create(Article article);

    @Override
    public List<Article> getAllArticles() {
        return findAll();
    }

    @Override
    public void addArticle(Article article) {
        article.setRemainingQuantity(0);
        create(article);
    }

    @Override
    public Integer addToStock(Integer articleId, Integer addedValue) throws IllegalArgumentException {
        if (addedValue == null || addedValue < 1) {
            throw new IllegalArgumentException("La valeur à ajouter doit être positive!");
        }
        return add(articleId, addedValue);
    }

    @Override
    public Integer subFromStock(Integer articleId, Integer addedValue) throws IllegalArgumentException {
        if (addedValue == null || addedValue < 1) {
            throw new IllegalArgumentException("La valeur à retrancher doit être positive!");
        }
        return add(articleId, -addedValue);
    }

    /**
     * Cette fonction assure l'accès unique à l'édition du solde d'un article.
     *
     * @param articleId Id de l'article
     * @param addedValue Valeur à ajouter
     * @return Le stock après ajout
     * @throws IllegalArgumentException
     */
    private synchronized Integer add(Integer articleId, Integer addedValue) throws IllegalArgumentException {
        Article article = findById(articleId);
        if (article == null) {
            throw new IllegalArgumentException("Aucun article avec pour ID " + articleId);
        }
        if (addedValue < 0 && addedValue + article.getRemainingQuantity() < 0) {
            throw new IllegalArgumentException("Opération impossible: Le stock actuel est inférieur à la demande");
        }
        article.setRemainingQuantity(article.getRemainingQuantity() + addedValue);
        edit(article);
        return article.getRemainingQuantity();
    }

}
