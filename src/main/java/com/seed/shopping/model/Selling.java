/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Selling implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "selling_date", nullable = false)
    private Calendar date;

    private String client;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Selling() {
    }

    public Selling(Calendar date, String client) {
        this.date = date;
        this.client = client;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
//</editor-fold>

}
