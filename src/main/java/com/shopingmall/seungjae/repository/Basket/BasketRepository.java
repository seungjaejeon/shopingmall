package com.shopingmall.seungjae.repository.Basket;

import com.shopingmall.seungjae.domain.Basket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository {
    Basket save(Basket basket);
    Basket findByMemberId(Long memberId);
}
