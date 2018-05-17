/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl;

import com.seed.shopping.bean.SellingArticleDataManager;
import com.seed.shopping.bean.SellingDataManager;
import com.seed.shopping.model.Selling;
import com.seed.shopping.model.SellingArticle;
import com.seed.shopping.service.impl.logic.AbstractSellingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Service
public class SellingServiceImpl extends AbstractSellingService{

    @Autowired
    private SellingDataManager sellingDataManager;
    @Autowired
    private SellingArticleDataManager sellingArticleDataManager;

    @Override
    public List<SellingArticle> findArticlesBySelling(Selling selling) {
        return sellingArticleDataManager.findArticlesByBuying(selling);
    }

    @Override
    public void create(Selling selling) {
        sellingDataManager.create(selling);
    }

    @Override
    public void create(SellingArticle sellingArticle) {
        sellingArticleDataManager.create(sellingArticle);
    }

    @Override
    public List<Selling> findAll() {
        return sellingDataManager.findAll();
    }

}
