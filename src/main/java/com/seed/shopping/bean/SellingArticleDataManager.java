/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.bean;

import com.seed.shopping.model.SellingArticle;
import org.springframework.stereotype.Component;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Component
public class SellingArticleDataManager extends AbstractDataManager<SellingArticle> {

    private Long nextId = 1L;

    @Override
    protected synchronized void generateId(SellingArticle object) {
        object.setId(nextId++);
    }

}
