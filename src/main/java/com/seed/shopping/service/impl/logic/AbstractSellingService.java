/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl.logic;

import com.seed.shopping.model.Selling;
import com.seed.shopping.model.SellingArticle;
import com.seed.shopping.service.contract.ArticleService;
import com.seed.shopping.service.contract.SellingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public abstract class AbstractSellingService implements SellingService {

    @Autowired
    private ArticleService articleService;

    public abstract void create(Selling selling);

    public abstract void create(SellingArticle sellingArticle);

    public abstract List<Selling> findAll();

    @Override
    public List<Selling> getAllSellings() {
        return findAll();
    }

    @Override
    public void saveSelling(List<SellingArticle> articles) {
        Selling selling = articles.get(0).getSelling();
        create(selling);
        for (SellingArticle sa : articles) {
            sa.setSelling(selling);
            articleService.subFromStock(sa.getArticle().getId(), sa.getQuantity());
            create(sa);
        }
    }

}
