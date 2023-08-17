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
    public static Basket createBasket(Member member) { // 장바구니를 생성하는 정적 메서드입니다.
        // Member를 인자로 받아 새로운 Basket 엔티티를 생성하고 member를 설정하여 반환합니다.
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
//이 클래스는 장바구니를 나타내며, 회원(Member)과 장바구니 항목(BasketItem) 간의 관계를 맺는 역할을 수행합니다.
// member 필드로 장바구니를 생성한 회원과 연결하며, basketItems 필드로 장바구니에 속한 항목들을 관리합니다.