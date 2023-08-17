package com.shopingmall.seungjae.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data @Entity
public class BasketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketItemId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="basketId")
    private Basket basket;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="itemId")
    private Item item;

    public static BasketItem createBasketItem(Basket basket, Item item) {
        BasketItem basketItem = new BasketItem();
        basketItem.setBasket(basket);
        basketItem.setItem(item);
        return basketItem;
    }
    @Override
    public String toString() {
        return "BasketItem{" +
                "basketItemId=" + basketItemId +
                // 필요한 필드만 출력
                '}';
    }
}
