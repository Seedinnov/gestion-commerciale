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
public class SellingArticle {

    private Long id;

    private Selling selling;

    private Article article;

    private Integer quantity = 1;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public SellingArticle() {
    }

    public SellingArticle(Selling selling, Article article, Integer quantity) {
        this.selling = selling;
        this.article = article;
        this.quantity = quantity;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public Selling getSelling() {
        return selling;
    }

    public void setSelling(Selling selling) {
        this.selling = selling;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
//</editor-fold>

}
