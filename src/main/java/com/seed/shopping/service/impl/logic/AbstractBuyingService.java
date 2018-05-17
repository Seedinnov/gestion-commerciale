/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl.logic;

import com.seed.shopping.model.Buying;
import com.seed.shopping.model.BuyingArticle;
import com.seed.shopping.service.contract.ArticleService;
import com.seed.shopping.service.contract.BuyingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public abstract class AbstractBuyingService implements BuyingService {

    @Autowired
    private ArticleService articleService;

    public abstract List<Buying> findAll();

    public abstract void create(Buying buying);

    public abstract void create(BuyingArticle buyingArticle);

    @Override
    public List<Buying> getAllBuyings() {
        return findAll();
    }

    @Override
    public void saveBuying(List<BuyingArticle> articles) {
        Buying buying = articles.get(0).getBuying();
        create(buying);
        for (BuyingArticle ba : articles) {
            ba.setBuying(buying);
            articleService.addToStock(ba.getArticle().getId(), ba.getQuantity());
            create(ba);
        }
    }

}
