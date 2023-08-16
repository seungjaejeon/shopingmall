package com.shopingmall.seungjae.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;
    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;
    private int basketCount;
    private int basketPrice;
}

