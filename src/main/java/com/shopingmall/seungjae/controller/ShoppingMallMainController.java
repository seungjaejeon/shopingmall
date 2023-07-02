package com.shopingmall.seungjae.controller;

import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j @RequiredArgsConstructor
public class ShoppingMallMainController {
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String homeLogin(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
        log.info("memberId = {}",memberId);
        if (memberId == null) {
            log.info("memberId = Null");
            return "main";
        }
        Member loginMember = memberRepository.findById(memberId);
        if (loginMember == null) {
            log.info("memberId = {}",memberId);
            return "main";
        }
        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}
