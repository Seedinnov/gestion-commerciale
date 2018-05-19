/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.rest.json;

import com.seed.shopping.model.Article;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public class ArticleInputJson {

    private String name;

    private Double buyingPrise;

    private Double sellingPrise;

    private Integer remainingQuantity = 0;

    //<editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBuyingPrise() {
        return buyingPrise;
    }

    public void setBuyingPrise(Double buyingPrise) {
        this.buyingPrise = buyingPrise;
    }

    public Double getSellingPrise() {
        return sellingPrise;
    }

    public void setSellingPrise(Double sellingPrise) {
        this.sellingPrise = sellingPrise;
    }

    public Integer getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Integer remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }
//</editor-fold>

    /**
     * Construit et retourne une instance de l'entité
     *
     * @return
     */
    public Article build() {
        return new Article(name, buyingPrise, sellingPrise);
    }

}
