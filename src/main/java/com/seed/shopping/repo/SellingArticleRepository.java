/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.repo;

import com.seed.shopping.model.SellingArticle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public interface SellingArticleRepository extends JpaRepository<SellingArticle, Long> {

    @Query("SELECT sa FROM SellingArticle sa WHERE sa.selling.id = ?1")
    List<SellingArticle> findArticlesBySellingId(Integer sellingId);

}
