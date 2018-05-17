/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.bean;

import com.seed.shopping.model.Article;
import org.springframework.stereotype.Component;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Component
public class ArticleDataManager extends AbstractDataManager<Article> {

    private Integer nextId = 1;

    @Override
    protected synchronized void generateId(Article object) {
        object.setId(nextId++);
    }

}
