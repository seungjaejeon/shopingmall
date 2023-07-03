package com.shopingmall.seungjae.controller;

import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j @RequestMapping("member/signup") @RequiredArgsConstructor
public class ShoppingMallMemberJoinController {
    private final MemberService memberService;
    @GetMapping
    public String JoinPage(@ModelAttribute Member member, Model model){
        model.addAttribute("member", member);
        return "join/joinPage";
    }

    @PostMapping
    public String CreateMember(@ModelAttribute Member member, Model model){
        //검증
        Map<String, String> errors = new HashMap<>();
        if(!StringUtils.hasText(member.getName())){
            errors.put("name", "문자를 적으셔야 합니다.");
        }
        if(!StringUtils.hasText(member.getLoginId())||member.getLoginId().length()<3||member.getLoginId().length()>10){
            errors.put("loginId", "올바르지 않은 ID: 문자가 있어야하고 아이디의 길이는 3자 이상 10자 이하여야 합니다.");
        }
        if(member.getPassword().length()<3||member.getPassword().length()>10){
            errors.put("password", "올바르지 않은 PASSWORD: 비밀번호의 길이는 3자 이상 10자 이하여야 합니다.");
        }
        model.addAttribute("member", member);
        if(!errors.isEmpty()){
            log.info("errors = {}", errors);
            model.addAttribute("errors", errors);
            return "join/joinPage";
        }
        memberService.join(member);
        log.info("member={}", member);
        return "redirect:/";
    }

    @ExceptionHandler(IllegalStateException.class)
    public String JoinError() {
        return "join/joinError";
    }
}
