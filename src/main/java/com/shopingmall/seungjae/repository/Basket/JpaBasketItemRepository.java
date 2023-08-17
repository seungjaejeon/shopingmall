package com.shopingmall.seungjae.repository.Basket;

import com.shopingmall.seungjae.domain.BasketItem;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class JpaBasketItemRepository implements BasketItemRepository {
    private final EntityManager em;
    @Override
    public BasketItem save(BasketItem basketItem) {
        em.persist(basketItem);
        return basketItem;
    }
    @Override
    public void delete(BasketItem basketItem) {
        em.remove(basketItem);
    }

}
