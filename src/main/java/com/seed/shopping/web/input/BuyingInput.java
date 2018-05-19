/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.web.input;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public class BuyingInput {

    private Integer articleId;

    private Integer quantity = 1;

    //<editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "BuyingInput{" + "quantity=" + quantity + ", articleId=" + articleId + '}';
    }

}
