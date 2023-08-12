//package com.shopingmall.seungjae.controller.Basket;
//
//import com.shopingmall.seungjae.controller.Member.SessionConst;
//import com.shopingmall.seungjae.domain.Member;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttribute;
//
//@Controller
//@RequestMapping("/basket")
//@RequiredArgsConstructor
//public class ShoppingMallBasketController {
//    // 내 장바구니 페이지 return
//    @GetMapping()
//    public String BasketPage(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
//        return "basket/basketPage";
//    }
////    물품 추가하기
//    @PostMapping("/{itemId}")
//    public String AddBasket(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
//
//    }
//    //물품 삭제하기
//    @GetMapping("/{itemId}")
//    public String AddBasket(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
//
//    }
//    //물품 구매하기
//    @PostMapping("/purchase")
//    public String AddBasket(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
//
//    }
//}
