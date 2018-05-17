/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.bean;

import com.seed.shopping.model.Buying;
import org.springframework.stereotype.Component;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Component
public class BuyingDataManager extends AbstractDataManager<Buying> {

    private Integer nextId = 1;

    @Override
    protected synchronized void generateId(Buying object) {
        object.setId(nextId++);
    }

}
