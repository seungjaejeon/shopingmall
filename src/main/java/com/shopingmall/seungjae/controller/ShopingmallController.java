package com.shopingmall.seungjae.controller;

import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopingmallController {
    private final MemberService memberService;

    public ShopingmallController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/main")
    public String MainPage(){
        return "main";
    }
    @GetMapping("/member/login")
    public String Loginpage(MemberForm memberForm){
        return "loginpage";
    }

//    @PostMapping("/member/login")
//    public String IsCorrect(){
//
//    }
    @GetMapping("/member/join")
    public String JoinPage(){
        return "joinPage";
    }
    @PostMapping("/member/join")
    public String CreateMember(MemberForm memberForm){
        Member member = new Member();
        member.setId(memberForm.getId());
        member.setName(memberForm.getName());
        member.setPassword(memberForm.getPassword());
        member.setDescription(memberForm.getDescription());
        memberService.join(member);
        System.out.println(member.getName());
        return "redirect:/main";
    }
    @ExceptionHandler(IllegalStateException.class)
    public String JoinError() {
        return "joinerror";
    }
}
