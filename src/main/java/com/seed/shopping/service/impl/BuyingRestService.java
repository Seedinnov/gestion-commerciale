/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl;

import com.seed.shopping.model.Buying;
import com.seed.shopping.model.BuyingArticle;
import com.seed.shopping.service.contract.BuyingService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Service
@Primary
public class BuyingRestService implements BuyingService {

    private static final Logger LOG = LoggerFactory.getLogger(BuyingRestService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${seed.shopping.rest.buying.url}")
    private String buyingUrl;

    @Override
    public List<BuyingArticle> findArticlesByBuying(Buying buying) {
        List<BuyingArticle> result = new ArrayList<>();
        try {
            BuyingArticle[] response = restTemplate.getForObject(buyingUrl + "/" + buying.getId(), BuyingArticle[].class);
            result.addAll(Arrays.asList(response));
        } catch (RestClientException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Buying> getAllBuyings() {
        List<Buying> result = new ArrayList<>();
        try {
            Buying[] response = restTemplate.getForObject(buyingUrl, Buying[].class);
            result.addAll(Arrays.asList(response));
        } catch (RestClientException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public void saveBuying(List<BuyingArticle> articles) {
        restTemplate.postForLocation(buyingUrl, articles);
    }

}
