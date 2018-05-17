/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl;

import com.seed.shopping.bean.BuyingArticleDataManager;
import com.seed.shopping.bean.BuyingDataManager;
import com.seed.shopping.model.Buying;
import com.seed.shopping.model.BuyingArticle;
import com.seed.shopping.service.impl.logic.AbstractBuyingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Service
public class BuyingServiceImpl extends AbstractBuyingService {

    @Autowired
    private BuyingDataManager buyingDataManager;
    @Autowired
    private BuyingArticleDataManager buyingArticleDataManager;

    @Override
    public List<BuyingArticle> findArticlesByBuying(Buying buying) {
        return buyingArticleDataManager.findArticlesByBuying(buying);
    }

    @Override
    public List<Buying> findAll() {
        return buyingDataManager.findAll();
    }

    @Override
    public void create(Buying buying) {
        buyingDataManager.create(buying);
    }

    @Override
    public void create(BuyingArticle buyingArticle) {
        buyingArticleDataManager.create(buyingArticle);
    }

}
