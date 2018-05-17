package com.seed.shopping;

import com.seed.shopping.bean.BuyingArticleDataManager;
import com.seed.shopping.bean.SellingArticleDataManager;
import com.seed.shopping.model.Article;
import com.seed.shopping.model.BuyingArticle;
import com.seed.shopping.model.SellingArticle;
import com.seed.shopping.service.contract.ArticleService;
import com.seed.shopping.service.contract.BuyingService;
import com.seed.shopping.service.contract.SellingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = {
    "com.seed.shopping.config",
    "com.seed.shopping.bean",
    "com.seed.shopping.service.impl"
})
public class Application {

    @Autowired
    private BuyingService buyingService;
    @Autowired
    private SellingService sellingService;
    @Autowired
    private ArticleService articleService;

    @Autowired
    private BuyingArticleDataManager buyingArticleDataManager;
    @Autowired
    private SellingArticleDataManager sellingArticleDataManager;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/ba")
    public ResponseEntity bas() {
        return new ResponseEntity(buyingArticleDataManager.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/sa")
    public ResponseEntity sas() {
        return new ResponseEntity(sellingArticleDataManager.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/article")
    public ResponseEntity createArticle(@RequestBody Article article) {
        articleService.addArticle(article);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/sell")
    public ResponseEntity sell(@RequestBody List<SellingArticle> sellingArticles) {
        sellingService.saveSelling(sellingArticles);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/buy")
    public ResponseEntity buy(@RequestBody List<BuyingArticle> buyingArticles) {
        buyingService.saveBuying(buyingArticles);
        return new ResponseEntity(HttpStatus.OK);
    }

}
