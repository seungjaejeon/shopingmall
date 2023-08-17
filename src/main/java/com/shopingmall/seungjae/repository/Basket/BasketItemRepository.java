package com.shopingmall.seungjae.repository.Basket;

import com.shopingmall.seungjae.domain.BasketItem;

import java.util.List;

public interface BasketItemRepository {
    BasketItem save(BasketItem basketItem);
    void delete(BasketItem basketItem);
}
