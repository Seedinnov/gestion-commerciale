/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.util;

import com.seed.shopping.model.Article;
import com.seed.shopping.model.Buying;
import com.seed.shopping.model.Selling;
import java.util.List;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public class CustomResponseObject {

    private List<Article> articles;
    private List<Buying> buyings;
    private List<Selling> sellings;

    public CustomResponseObject() {
    }

    public CustomResponseObject(List<Article> articles, List<Buying> buyings, List<Selling> sellings) {
        this.articles = articles;
        this.buyings = buyings;
        this.sellings = sellings;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Buying> getBuyings() {
        return buyings;
    }

    public void setBuyings(List<Buying> buyings) {
        this.buyings = buyings;
    }

    public List<Selling> getSellings() {
        return sellings;
    }

    public void setSellings(List<Selling> sellings) {
        this.sellings = sellings;
    }

}
