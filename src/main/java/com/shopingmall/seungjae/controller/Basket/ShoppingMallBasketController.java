package com.shopingmall.seungjae.controller.Basket;

import com.shopingmall.seungjae.controller.Member.SessionConst;
import com.shopingmall.seungjae.domain.Basket;
import com.shopingmall.seungjae.domain.BasketItem;
import com.shopingmall.seungjae.domain.Item;
import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.repository.Basket.BasketRepository;
import com.shopingmall.seungjae.repository.Item.ItemRepository;
import com.shopingmall.seungjae.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basket")
@RequiredArgsConstructor
public class ShoppingMallBasketController {
    private final BasketService basketService;
    private final ItemRepository itemRepository;
    private final BasketRepository basketRepository;

    // 내 장바구니 페이지 return
    @GetMapping()
    public String BasketPage(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
        Basket basket = basketRepository.findByMemberId(loginMember.getId());
        List<BasketItem> basketItems = basket.getBasketItems();
        model.addAttribute("basketItems", basketItems);
        model.addAttribute("totalAmount", basketItems.size());
        int totalPrice = 0;
        for (BasketItem basketItem : basketItems) {
            totalPrice += basketItem.getItem().getPrice();
        }
        model.addAttribute("totalPrice",totalPrice);
        return "basket/basketPage";
    }
//    물품 추가하기
    @PostMapping("/{itemId}")
    public String AddBasket(@PathVariable Long itemId, @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
        Item item = itemRepository.findById(itemId);
        basketService.addBasket(loginMember, item);
        return "redirect:/basket";
    }
    //물품 삭제하기
    @GetMapping("/{itemId}")
    public String deleteItemAtBasket(@PathVariable Long itemId, @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
        Item item = itemRepository.findById(itemId);
        basketService.removeBasket(loginMember, item);
        return "redirect:/basket";
    }
//    //물품 구매하기
//    @PostMapping("/purchase")
//    public String AddBasket(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
//
//    }
}
