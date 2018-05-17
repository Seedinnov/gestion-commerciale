/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.repo;

import com.seed.shopping.model.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public interface ArticleRepository extends JpaRepository<Article, Integer>{
    
    @Query("SELECT a FROM Article a WHERE a.name LIKE '%?1%'")
    List<Article> findByName(String name);
    
}
