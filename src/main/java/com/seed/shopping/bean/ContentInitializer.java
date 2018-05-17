/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.bean;

import com.seed.shopping.model.Article;
import com.seed.shopping.model.Buying;
import com.seed.shopping.model.BuyingArticle;
import com.seed.shopping.model.Selling;
import com.seed.shopping.model.SellingArticle;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Component
public class ContentInitializer {

    @Autowired
    private BuyingDataManager buyingDataManager;
    @Autowired
    private SellingDataManager sellingDataManager;
    @Autowired
    private ArticleDataManager articleDataManager;
    @Autowired
    private BuyingArticleDataManager buyingArticleDataManager;
    @Autowired
    private SellingArticleDataManager sellingArticleDataManager;

    @PostConstruct
    private void initAppContent() {
        //Les articles
        Article gesiers = new Article("Gésiers De Boumnyebel", 75.0, 100.0);
        Article mets = new Article("Mets de Pistache d'Ebolowa", 80.0, 100.0);
        Article cola = new Article("Cola Bafia", 55.0, 100.0);
        Article mbitaCola = new Article("Mbita-Cola de Bamenda", 60.0, 100.0);
        Article vers = new Article("Vers Blancs de l'Est Cameroun", 45.0, 100.0);

        Buying buying;
        BuyingArticle ba;

        //Achat numéro 1
        buying = new Buying(Calendar.getInstance(), "Provider 1");
        ba = new BuyingArticle(buying, gesiers, 10);
        buyingArticleDataManager.create(ba);
        gesiers.setRemainingQuantity(gesiers.getRemainingQuantity() + 10);
        ba = new BuyingArticle(buying, mets, 3);
        buyingArticleDataManager.create(ba);
        mets.setRemainingQuantity(mets.getRemainingQuantity() + 3);
        ba = new BuyingArticle(buying, cola, 9);
        buyingArticleDataManager.create(ba);
        cola.setRemainingQuantity(cola.getRemainingQuantity() + 9);
        buyingDataManager.create(buying);

        //Achat numéro 2
        buying = new Buying(Calendar.getInstance(), "Provider 2");
        ba = new BuyingArticle(buying, mbitaCola, 1);
        buyingArticleDataManager.create(ba);
        mbitaCola.setRemainingQuantity(mbitaCola.getRemainingQuantity() + 1);
        buyingDataManager.create(buying);

        Selling selling;
        SellingArticle sa;

        //Vente numéro 1
        selling = new Selling(Calendar.getInstance(), "TIAYO");
        sa = new SellingArticle(selling, gesiers, 5);
        sellingArticleDataManager.create(sa);
        gesiers.setRemainingQuantity(gesiers.getRemainingQuantity() - 5);
        sa = new SellingArticle(selling, mbitaCola, 1);
        sellingArticleDataManager.create(sa);
        mbitaCola.setRemainingQuantity(mbitaCola.getRemainingQuantity() - 1);
        sellingDataManager.create(selling);

        //Vente numéro 2
        selling = new Selling(Calendar.getInstance(), "HCurtis");
        sa = new SellingArticle(selling, gesiers, 2);
        sellingArticleDataManager.create(sa);
        gesiers.setRemainingQuantity(gesiers.getRemainingQuantity() - 2);
        sa = new SellingArticle(selling, mets, 3);
        sellingArticleDataManager.create(sa);
        mets.setRemainingQuantity(mets.getRemainingQuantity() - 3);
        sellingDataManager.create(selling);

        articleDataManager.create(gesiers);
        articleDataManager.create(mets);
        articleDataManager.create(cola);
        articleDataManager.create(mbitaCola);
        articleDataManager.create(vers);
    }

}
