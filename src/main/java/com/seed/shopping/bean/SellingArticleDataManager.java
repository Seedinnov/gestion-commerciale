/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.bean;

import com.seed.shopping.model.Selling;
import com.seed.shopping.model.SellingArticle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public List<SellingArticle> findArticlesByBuying(Selling selling) {
        List<SellingArticle> result = new ArrayList<>();
        for (SellingArticle s : objects) {
            if (Objects.equals(s.getSelling().getId(), selling.getId())) {
                result.add(s);
            }
        }
        return result;
    }

}
