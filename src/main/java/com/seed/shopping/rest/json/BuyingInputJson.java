/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.rest.json;

import java.util.List;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public class BuyingInputJson {

    private String provider;

    private List<Item> items;

    //<editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
//</editor-fold>

    public class Item {

        private Integer articleId;

        private Integer quantity;

        //<editor-fold defaultstate="collapsed" desc="Getters And Setters">
        public Integer getArticleId() {
            return articleId;
        }

        public void setArticleId(Integer articleId) {
            this.articleId = articleId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
//</editor-fold>

    }

}
