/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.bean;

import com.seed.shopping.model.Article;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public List<Article> findByName(String name) {
        List<Article> result = new ArrayList<>();
        for (Article a : objects) {
            if (a.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(a);
            }
        }
        return result;
    }

    public Article findById(Integer articleId) {
        for (Article a : objects) {
            if (Objects.equals(a.getId(), articleId)) {
                return a;
            }
        }
        return null;
    }

}
