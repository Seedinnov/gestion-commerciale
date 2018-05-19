/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.rest.server;

import com.seed.shopping.model.Selling;
import com.seed.shopping.model.SellingArticle;
import com.seed.shopping.rest.json.SellingInputJson;
import com.seed.shopping.service.contract.ArticleService;
import com.seed.shopping.service.contract.SellingService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@RestController
@RequestMapping("/rest/selling")
public class SellingRestServer {

    @Autowired
    private SellingService sellingService;
    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findAll() {
        return new ResponseEntity(sellingService.getAllSellings(),
                HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findByBuying(@PathVariable("id") Integer sellingId) {
        Selling selling = new Selling();
        selling.setId(sellingId);
        return new ResponseEntity(sellingService.findArticlesBySelling(selling),
                HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(
            @RequestBody(required = true) SellingInputJson sellingInput) {
        List<SellingArticle> saveList = new ArrayList<>();
        Selling selling = new Selling(
                Calendar.getInstance(),
                sellingInput.getClient()
        );
        sellingInput.getItems().forEach((item) -> {
            saveList.add(new SellingArticle(selling,
                    articleService.findById(item.getArticleId()),
                    item.getQuantity()
            ));
        });
        sellingService.saveSelling(saveList);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
