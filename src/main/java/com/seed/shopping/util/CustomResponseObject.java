/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.util;

import com.seed.shopping.model.Article;
import com.seed.shopping.model.Buying;
import com.seed.shopping.model.BuyingArticle;
import com.seed.shopping.model.Selling;
import com.seed.shopping.model.SellingArticle;
import java.util.List;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public class CustomResponseObject {

    private List<Article> articles;
    private List<Buying> buyings;
    private List<BuyingArticle> buyingArticles;
    private List<Selling> sellings;
    private List<SellingArticle> sellingArticles;

    public CustomResponseObject() {
    }

    public CustomResponseObject(List<Article> articles, List<Buying> buyings, List<BuyingArticle> buyingArticles, List<Selling> sellings, List<SellingArticle> sellingArticles) {
        this.articles = articles;
        this.buyings = buyings;
        this.buyingArticles = buyingArticles;
        this.sellings = sellings;
        this.sellingArticles = sellingArticles;
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

    public List<BuyingArticle> getBuyingArticles() {
        return buyingArticles;
    }

    public void setBuyingArticles(List<BuyingArticle> buyingArticles) {
        this.buyingArticles = buyingArticles;
    }

    public List<Selling> getSellings() {
        return sellings;
    }

    public void setSellings(List<Selling> sellings) {
        this.sellings = sellings;
    }

    public List<SellingArticle> getSellingArticles() {
        return sellingArticles;
    }

    public void setSellingArticles(List<SellingArticle> sellingArticles) {
        this.sellingArticles = sellingArticles;
    }

}
