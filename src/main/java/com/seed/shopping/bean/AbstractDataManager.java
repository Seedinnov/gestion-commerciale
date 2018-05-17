/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 * @param <T>
 */
public abstract class AbstractDataManager<T> {

    protected final List<T> objects = new ArrayList<>();

    /**
     * Enregistre une nouvelle entrée de l'objet passé en paramètre dans la
     * liste existante
     *
     * @param object entrée à enregistrer
     */
    public void create(T object) {
        generateId(object);
        objects.add(object);
    }

    /**
     * Fourni la liste des objets enregistrés
     *
     * @return liste de tous les objets enregistrés
     */
    public List<T> findAll() {
        List<T> result = new ArrayList<>();
        result.addAll(objects);
        return result;
    }

    protected abstract void generateId(T object);

}
