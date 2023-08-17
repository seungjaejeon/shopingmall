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
//이 클래스는 장바구니에 담긴 개별 상품을 표현하며, 장바구니(Basket)와 상품(Item) 간의 관계를 맺습니다.
// basket 필드로 어떤 장바구니에 속하는지, item 필드로 어떤 상품을 나타내는지를 나타냅니다.