/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.rest.server;

import com.seed.shopping.model.Buying;
import com.seed.shopping.model.BuyingArticle;
import com.seed.shopping.rest.json.BuyingInputJson;
import com.seed.shopping.service.contract.ArticleService;
import com.seed.shopping.service.contract.BuyingService;
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
@RequestMapping("/rest/buying")
public class BuyingRestServer {

    @Autowired
    private BuyingService buyingService;
    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findAll() {
        return new ResponseEntity(buyingService.getAllBuyings(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findByBuying(@PathVariable("id") Integer buyingId) {
        Buying buying = new Buying();
        buying.setId(buyingId);
        return new ResponseEntity(buyingService.findArticlesByBuying(buying),
                 HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(
            @RequestBody(required = true) BuyingInputJson buyingInput) {
        List<BuyingArticle> saveList = new ArrayList<>();
        Buying buying = new Buying(
                Calendar.getInstance(),
                buyingInput.getProvider()
        );
        buyingInput.getItems().forEach((item) -> {
            saveList.add(new BuyingArticle(buying,
                    articleService.findById(item.getArticleId()),
                    item.getQuantity()
            ));
        });
        buyingService.saveBuying(saveList);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
