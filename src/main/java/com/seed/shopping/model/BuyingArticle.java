/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.model;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public class BuyingArticle {

    private Long id;

    private Buying buying;

    private Article article;

    private Integer quantity = 1;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public BuyingArticle() {
    }

    public BuyingArticle(Buying buying, Article article, Integer quantity) {
        this.buying = buying;
        this.article = article;
        this.quantity = quantity;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public Buying getBuying() {
        return buying;
    }

    public void setBuying(Buying buying) {
        this.buying = buying;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
//</editor-fold>

}
