/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.web.ctrl;

import com.seed.shopping.model.Article;
import com.seed.shopping.service.contract.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Controller
public class ArticleCtrl {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public String greeting(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        model.addAttribute("article", new Article());
        return "article";
    }

    @RequestMapping(value = "/article/create", method = RequestMethod.POST)
    public String createArticle(@ModelAttribute Article article, BindingResult errors, Model model) {
        articleService.addArticle(article);
        return greeting(model);
    }
    
}
