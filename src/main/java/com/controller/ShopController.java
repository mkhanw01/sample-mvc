package com.controller;

import com.exception.ShopNotFoundException;
import com.model.Shop;
import com.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.misc.Contended;

import java.util.List;

/**
 * Created by khan on 08/12/16.
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopController {
    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView newShopPage() {
        ModelAndView modelAndView = new ModelAndView("shopNew", "shop", new Shop());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView crateNewShop(@ModelAttribute Shop shop) {
        ModelAndView modelAndView = new ModelAndView();
        shopService.create(shop);
        modelAndView.setViewName("redirect:/index.html");
        return modelAndView;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView shopList() {
        List<Shop> shopList = shopService.findAll();
        return new ModelAndView("shopList", "shopList", shopList);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editShopPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("editShop");
        Shop shop = shopService.findById(id);
        modelAndView.addObject("shop", shop);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editshop(@ModelAttribute Shop shop) throws ShopNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        shopService.update(shop);
        modelAndView.setViewName("redirect:/index.html");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteshop(@PathVariable Integer id) throws ShopNotFoundException {
        Shop shop = shopService.delete(id);
        return new ModelAndView("redirect:/index.html");
    }
}
