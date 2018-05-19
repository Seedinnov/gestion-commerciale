/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.service.impl;

import com.seed.shopping.model.Selling;
import com.seed.shopping.model.SellingArticle;
import com.seed.shopping.service.contract.SellingService;
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
public class SellingRestService implements SellingService {

    private static final Logger LOG = LoggerFactory.getLogger(SellingRestService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${seed.shopping.rest.selling.url}")
    private String sellingUrl;

    @Override
    public List<Selling> getAllSellings() {
        List<Selling> result = new ArrayList<>();
        try {
            Selling[] response = restTemplate.getForObject(sellingUrl, Selling[].class);
            result.addAll(Arrays.asList(response));
        } catch (RestClientException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public void saveSelling(List<SellingArticle> articles) {
        restTemplate.postForLocation(sellingUrl, articles);
    }

    @Override
    public List<SellingArticle> findArticlesBySelling(Selling selling) {
        List<SellingArticle> result = new ArrayList<>();
        try {
            SellingArticle[] response = restTemplate.getForObject(sellingUrl + "/" + selling.getId(), SellingArticle[].class);
            result.addAll(Arrays.asList(response));
        } catch (RestClientException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

}
