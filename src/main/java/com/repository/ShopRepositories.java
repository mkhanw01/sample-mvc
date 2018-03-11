package com.repository;
import com.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by khan on 08/12/16.
 */
public interface ShopRepositories extends JpaRepository<Shop,Integer>,ShopCustomRepository{
}
