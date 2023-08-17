package com.shopingmall.seungjae.repository.Basket;

import com.shopingmall.seungjae.domain.Basket;
import com.shopingmall.seungjae.domain.Item;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository @RequiredArgsConstructor
@Transactional
public class JpaBasketRepository implements BasketRepository {
    private final EntityManager em;
    @Override
    public Basket save(Basket basket) {
        em.persist(basket);
        return basket;
    }

    @Override
    public Basket findByMemberId(Long memberId) {
        return em.find(Basket.class,memberId);
    }
}
