package com.shopingmall.seungjae.repository;

import com.shopingmall.seungjae.domain.Basket;
import com.shopingmall.seungjae.domain.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository {
    Basket save(Item item);
    Basket findAll();
    void delete(Item item);
}
