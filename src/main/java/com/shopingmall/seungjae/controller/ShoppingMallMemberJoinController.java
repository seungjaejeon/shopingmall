package com.shopingmall.seungjae.controller;

import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j @RequestMapping("member/signup")
public class ShoppingMallMemberJoinController {
    private final MemberService memberService;

    public ShoppingMallMemberJoinController(MemberService memberService) {
        this.memberService = memberService;
    }
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
