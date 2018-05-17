/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.contract;

import com.seed.shopping.model.Selling;
import com.seed.shopping.model.SellingArticle;
import java.util.List;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public interface SellingService {

    /**
     * Fourni la liste de toutes les ventes enregistrées
     *
     * @return La liste sus-mentionnée
     */
    List<Selling> getAllSellings();

    /**
     * Enregistre une nouvelle vente par la liste des articles concernés et des
     * quantités associées
     *
     * @param articles
     */
    void saveSelling(List<SellingArticle> articles);

    /**
     * Fourni la liste de tous les articles (+ quantité) concernés par la vente
     * passée en paramètre
     *
     * @param selling
     * @return Une liste d'entités SellingArticle liées à la vente en entrée
     */
    List<SellingArticle> findArticlesBySelling(Selling selling);

}
