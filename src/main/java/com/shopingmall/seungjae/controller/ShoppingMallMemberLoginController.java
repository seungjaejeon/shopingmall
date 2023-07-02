package com.shopingmall.seungjae.controller;

import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.repository.MemberRepository;
import com.shopingmall.seungjae.service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller  @Slf4j
@RequestMapping("/member/login")
public class ShoppingMallMemberLoginController {
    public ShoppingMallMemberLoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    private LoginService loginService;
    @GetMapping
    public String loginPage(){
        return "login/loginPage";
    }

    @PostMapping
    public String login(@RequestParam String loginId, @RequestParam String password, HttpServletResponse response) {
        Member member = loginService.login(loginId, password);
        log.info("login? {}", member);
        if (member == null) {
           return "login/loginError";
        }
        //로그인 성공처리 쿠키
        //쿠키에 시간 정보를 주지 않으면 세션쿠키(브라우저 종료시 모두 종료)
        Cookie idCookie = new Cookie("memberId", String.valueOf(member.getId()));
        response.addCookie(idCookie);
        log.info("cookie = {}",idCookie);
        return "redirect:/";
    }
}
