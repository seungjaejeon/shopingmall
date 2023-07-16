package com.shopingmall.seungjae.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Item {
    @NotEmpty
    private String itemName;
    @NotEmpty
    private Integer price;
    private String itemDescription;
    private Long itemId;
    @NotEmpty
    private String sellerName;
}
