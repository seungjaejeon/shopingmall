package com.shopingmall.seungjae.service;

import com.shopingmall.seungjae.domain.Basket;
import com.shopingmall.seungjae.domain.BasketItem;
import com.shopingmall.seungjae.domain.Item;
import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.repository.Basket.BasketItemRepository;
import com.shopingmall.seungjae.repository.Basket.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final BasketItemRepository basketItemRepository;
    public void addBasket(Member member, Item newItem) {
        Basket basket = basketRepository.findByMemberId(member.getId()); //넣을 장바구니
        BasketItem basketItem = BasketItem.createBasketItem(basket, newItem);
        //TODO 장바구니에 이미 있는 상품이면 추가 불가.
        basketItemRepository.save(basketItem);

    }
    public void removeBasket(Member member, Item deleteItem) {
        Basket basket = basketRepository.findByMemberId(member.getId());

        // 해당 상품을 장바구니에서 찾아서 삭제
        BasketItem basketItem = basket.getBasketItems()
                .stream()
                .filter(item -> item.getItem().equals(deleteItem))
                .findFirst()
                .orElse(null);

        if (basketItem != null) {
            basketItemRepository.delete(basketItem);
        }
    }
}
