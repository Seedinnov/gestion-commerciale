/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Article implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double buyingPrise;

    @Column(nullable = false)
    private Double sellingPrise;

    @Column(nullable = false)
    private Integer remainingQuantity = 0;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Article() {
    }

    public Article(String name, Double buyingPrise, Double sellingPrise) {
        this.name = name;
        this.buyingPrise = buyingPrise;
        this.sellingPrise = sellingPrise;
    }
//</editor-fold>

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Integer remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }
//</editor-fold>

    @Override
    public String toString() {
        return name + '(' + remainingQuantity + ')';
    }

}
