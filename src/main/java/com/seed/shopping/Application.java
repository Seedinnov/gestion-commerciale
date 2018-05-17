package com.seed.shopping;

import com.seed.shopping.bean.ArticleDataManager;
import com.seed.shopping.bean.BuyingArticleDataManager;
import com.seed.shopping.bean.BuyingDataManager;
import com.seed.shopping.bean.SellingArticleDataManager;
import com.seed.shopping.bean.SellingDataManager;
import com.seed.shopping.util.CustomResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"com.seed.shopping.bean"})
public class Application {

    @Autowired
    private BuyingDataManager buyingDataManager;
    @Autowired
    private SellingDataManager sellingDataManager;
    @Autowired
    private ArticleDataManager articleDataManager;
    @Autowired
    private BuyingArticleDataManager buyingArticleDataManager;
    @Autowired
    private SellingArticleDataManager sellingArticleDataManager;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllDatas() {
        CustomResponseObject response = new CustomResponseObject(
                articleDataManager.findAll(),
                buyingDataManager.findAll(),
                buyingArticleDataManager.findAll(),
                sellingDataManager.findAll(),
                sellingArticleDataManager.findAll());
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
