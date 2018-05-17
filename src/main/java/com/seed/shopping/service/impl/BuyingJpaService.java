/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl;

import com.seed.shopping.model.Buying;
import com.seed.shopping.model.BuyingArticle;
import com.seed.shopping.repo.BuyingArticleRepository;
import com.seed.shopping.repo.BuyingRepository;
import com.seed.shopping.service.impl.logic.AbstractBuyingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Service
@Primary
public class BuyingJpaService extends AbstractBuyingService {

    @Autowired
    private BuyingRepository buyingRepository;
    @Autowired
    private BuyingArticleRepository buyingArticleRepository;

    @Override
    public List<Buying> findAll() {
        return buyingRepository.findAll();
    }

    @Override
    public void create(Buying buying) {
        buyingRepository.save(buying);
    }

    @Override
    public void create(BuyingArticle buyingArticle) {
        buyingArticleRepository.save(buyingArticle);
    }

    @Override
    public List<BuyingArticle> findArticlesByBuying(Buying buying) {
        return buyingArticleRepository.findArticlesByBuyingId(buying.getId());
    }

    /**
     * Cette redéfinition permet d'encapsuler toutes les opérations en base de
     * données de cette fonction dans une unique transaction
     *
     * @param articles
     */
    @Override
    @Transactional
    public void saveBuying(List<BuyingArticle> articles) {
        super.saveBuying(articles);
    }

}
