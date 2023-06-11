package com.shopingmall.seungjae.controller;

import com.shopingmall.seungjae.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopingmallController {
    @GetMapping("/main")
    public String MainPage(){
        return "main";
    }
    @GetMapping("/member/login")
    public String Loginpage(){
        return "loginpage";
    }

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
        System.out.println(member.getName());
        return "redirect:/main";
    }
}
