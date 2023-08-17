package com.shopingmall.seungjae.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity @Data
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberId")
    private Member member;
    @OneToMany(mappedBy = "basket")
    private List<BasketItem> basketItems = new ArrayList<>();
    public static Basket createBasket(Member member) { // 장바구니 생성
        Basket basket = new Basket();
        basket.setMember(member);
        return basket;
    }
    @Override
    public String toString() {
        return "Basket{" +
                "basketId=" + basketId +
                '}';
    }
}