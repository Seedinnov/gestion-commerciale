/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.bean;

import com.seed.shopping.model.BuyingArticle;
import org.springframework.stereotype.Component;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Component
public class BuyingArticleDataManager extends AbstractDataManager<BuyingArticle> {

    private Long nextId = 1L;

    @Override
    protected synchronized void generateId(BuyingArticle object) {
        object.setId(nextId++);
    }

}
