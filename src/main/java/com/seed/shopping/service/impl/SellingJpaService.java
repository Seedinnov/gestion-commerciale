/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl;

import com.seed.shopping.model.Selling;
import com.seed.shopping.model.SellingArticle;
import com.seed.shopping.repo.SellingArticleRepository;
import com.seed.shopping.repo.SellingRepository;
import com.seed.shopping.service.impl.logic.AbstractSellingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Service
@Primary
public class SellingJpaService extends AbstractSellingService {

    @Autowired
    private SellingRepository sellingRepository;
    @Autowired
    private SellingArticleRepository sellingArticleRepository;

    @Override
    public void create(Selling selling) {
        sellingRepository.save(selling);
    }

    @Override
    public void create(SellingArticle sellingArticle) {
        sellingArticleRepository.save(sellingArticle);
    }

    @Override
    public List<Selling> findAll() {
        return sellingRepository.findAll();
    }

    @Override
    public List<SellingArticle> findArticlesBySelling(Selling selling) {
        return sellingArticleRepository.findArticlesBySellingId(selling.getId());
    }

}
