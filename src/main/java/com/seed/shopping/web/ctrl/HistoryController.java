/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.web.ctrl;

import com.seed.shopping.service.contract.BuyingService;
import com.seed.shopping.service.contract.SellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
@Controller
public class HistoryController {
    
    @Autowired
    private BuyingService buyingService;
    @Autowired
    private SellingService sellingService;
    
    @GetMapping("/historique")
    public String greeting(Model model) {
        model.addAttribute("buyings", buyingService.getAllBuyings());
        model.addAttribute("sellings", sellingService.getAllSellings());
        return "historique";
    }
    
}
