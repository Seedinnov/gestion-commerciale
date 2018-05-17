/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.contract;

import com.seed.shopping.model.Buying;
import com.seed.shopping.model.BuyingArticle;
import java.util.List;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public interface BuyingService {

    /**
     * Fourni la liste de tous les approvisionnements (achats) enregistrés
     *
     * @return La liste sus-mentionnée
     */
    List<Buying> getAllBuyings();

    /**
     * Enregistre un nouvel approvisionnement par la liste des articles
     * concernés et des quantités associées
     *
     * @param articles
     */
    void saveBuying(List<BuyingArticle> articles);

    /**
     * Fourni la liste de tous les articles (+ quantité) concernés par
     * l'approvisionnement passé en paramètre
     *
     * @param buying
     * @return Une liste d'entités BuyingArticle liés à l'approvisionnement en
     * entrée
     */
    List<BuyingArticle> findArticlesByBuying(Buying buying);

}
