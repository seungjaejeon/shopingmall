package com.shopingmall.seungjae.controller;

import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j @RequestMapping("member/signup") @RequiredArgsConstructor
public class ShoppingMallMemberJoinController {
    private final MemberService memberService;
    @GetMapping
    public String JoinPage(){
        return "join/joinPage";
    }

    @PostMapping
    public String CreateMember(@ModelAttribute Member member){
        memberService.join(member);
        log.info("member={}", member);
        return "redirect:/";
    }

    @ExceptionHandler(IllegalStateException.class)
    public String JoinError() {
        return "join/joinError";
    }
}
