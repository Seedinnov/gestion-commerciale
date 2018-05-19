/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.rest.server;

import com.seed.shopping.model.Article;
import com.seed.shopping.rest.json.ArticleInputJson;
import com.seed.shopping.service.contract.ArticleService;
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
@RequestMapping("/rest/article")
public class ArticleRestServer {

    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findAll() {
        return new ResponseEntity(articleService.getAllArticles(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object findById(@PathVariable("id") Integer id) {
        Article article = articleService.findById(id);
        if (article == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(article, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody(required = true) ArticleInputJson articleInput) {
        Article article = articleInput.build();
        articleService.addArticle(article);
        return new ResponseEntity(article, HttpStatus.CREATED);
    }

}
