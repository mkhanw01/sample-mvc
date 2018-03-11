package com.service;

import com.exception.ShopNotFoundException;
import com.model.Shop;

import java.util.List;

/**
 * Created by khan on 08/12/16.
 */
public interface ShopService {
    public Shop create(Shop shop);
    public Shop delete(int id)throws ShopNotFoundException;
    public List<Shop> findAll();
    public Shop update(Shop shop)throws ShopNotFoundException;
    public Shop findById(int id);
   // public Shop findByNumber(Integer emplNumber);
}
