/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.repo;

import com.seed.shopping.model.BuyingArticle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public interface BuyingArticleRepository extends JpaRepository<BuyingArticle, Long> {

    @Query("SELECT ba FROM BuyingArticle ba WHERE ba.buying.id = ?1")
    List<BuyingArticle> findArticlesByBuyingId(Integer BuyingId);

}
