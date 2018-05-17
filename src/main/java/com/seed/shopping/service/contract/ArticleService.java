/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.contract;

import com.seed.shopping.model.Article;
import java.util.List;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public interface ArticleService {

    /**
     * Lecture de tous les articles enregistrés
     *
     * @return les articles
     */
    List<Article> getAllArticles();

    /**
     * Enregistrement d'un nouvel article
     *
     * @param article
     */
    void addArticle(Article article);

    /**
     * Fourni la liste des articles comprenant l'expression fournie dans leur
     * nom
     *
     * @param name
     * @return les articles correspondants
     */
    List<Article> findByName(String name);

    /**
     * Recherche un article à partir de son id
     *
     * @param articleId
     * @return
     */
    Article findById(Integer articleId);

    /**
     * Ajoute dans le stock de l'article dont l'id est fourni avec la valeur
     * associée
     *
     * @param articleId Id de l'article dont le stock doit être incrémenté
     * @param addedValue Nombre d'articles à ajouter dans le stock
     * @return
     */
    Integer addToStock(Integer articleId, Integer addedValue) throws IllegalArgumentException;

    /**
     * Retranche dans le stock de l'article dont l'id est fourni avec la valeur
     * associée
     *
     * @param articleId Id de l'article dont le stock doit être retranchée
     * @param addedValue Nombre d'articles à retrancher dans le stock
     * @return
     */
    Integer subFromStock(Integer articleId, Integer addedValue) throws IllegalArgumentException;

}
