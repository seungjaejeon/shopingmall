package com.shopingmall.seungjae.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data @Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    @NotEmpty
    private String itemName;
    @NotNull
    private int price;
    @NotEmpty
    private String itemDescription;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Member member;
}
