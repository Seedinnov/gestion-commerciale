/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.web.ctrl;

import com.seed.shopping.model.Article;
import com.seed.shopping.model.BuyingArticle;
import com.seed.shopping.service.contract.ArticleService;
import com.seed.shopping.web.input.BuyingInput;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Controller
@SessionScope
public class CommandCtrl {

    private final List<BuyingArticle> command = new ArrayList<>();

    @Autowired
    private ArticleService articleService;

    @GetMapping("/commande")
    public String command(Model model) {
        model.addAttribute("command", command);
        model.addAttribute("buying", new BuyingInput());
        model.addAttribute("articles", articleService.getAllArticles());
        return "commande";
    }

    @RequestMapping(value = "/commande/ajout", method = RequestMethod.POST)
    public String createArticle(@ModelAttribute BuyingInput buying, BindingResult errors, Model model) {

        Article a = articleService.findById(buying.getArticleId());
        if (a == null) {
            errors.addError(new FieldError("Article", "id", "L'id Fourni n'est pas valide"));
        } else {
            command.add(new BuyingArticle(null, a, buying.getQuantity()));
        }
        return command(model);
    }

}
