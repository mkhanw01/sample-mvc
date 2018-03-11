package com.repository;

import com.model.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by khan on 13/12/16.
 */
public interface ShopCustomRepository {
    @Query("from Shop s where s.emplNumber=?1")
    public Shop findByEmplName(Integer emplNumber);
}
