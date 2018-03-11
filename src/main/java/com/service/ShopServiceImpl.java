package com.service;

import com.exception.ShopNotFoundException;
import com.model.Shop;
import com.repository.ShopRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by khan on 08/12/16.
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopRepositories shopRepositories;

    @Transactional
    public Shop create(Shop shop) {
        Shop createdShop = shop;
        return shopRepositories.save(createdShop);
    }

    @Transactional(rollbackFor = ShopNotFoundException.class)
    public Shop delete(int id) throws ShopNotFoundException {
        Shop deletedShop = shopRepositories.findOne(id);
        if (deletedShop == null) {
            throw new ShopNotFoundException();
        }
        shopRepositories.delete(deletedShop);
        return deletedShop;
    }

    @Transactional
    public Shop findByNumber(Integer emplNumber) {
        return shopRepositories.findByEmplName(emplNumber);
    }

    @Transactional
    public List<Shop> findAll() {
        return shopRepositories.findAll();
    }

    @Transactional(rollbackFor = ShopNotFoundException.class)
    public Shop update(Shop shop) throws ShopNotFoundException {
        Shop updatedShope = shopRepositories.findOne(shop.getId());
        if (updatedShope == null) {
            throw new ShopNotFoundException();
        }
        updatedShope.setName(shop.getName());
        updatedShope.setEmplNumber(shop.getEmplNumber());
        shopRepositories.save(updatedShope);
        return updatedShope;
    }

    @Transactional
    public Shop findById(int id) {
        return shopRepositories.findOne(id);
    }
}
