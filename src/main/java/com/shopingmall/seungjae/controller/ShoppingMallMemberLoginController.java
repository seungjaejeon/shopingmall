package com.shopingmall.seungjae.controller;

import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.service.LoginService;
import com.shopingmall.seungjae.service.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller  @Slf4j
@RequestMapping("/member") @RequiredArgsConstructor
public class ShoppingMallMemberLoginController {
    private final SessionManager sessionManager;
    private final LoginService loginService;
    @GetMapping("/login")
    public String loginPage(){
        return "login/loginPage";
    }
//    @PostMapping
//    public String login(@RequestParam String loginId, @RequestParam String password, HttpServletResponse response) {
//        Member member = loginService.login(loginId, password);
//        log.info("login? {}", member);
//        if (member == null) {
//           return "login/loginError";
//        }
//        //로그인 성공처리 쿠키
//        //쿠키에 시간 정보를 주지 않으면 세션쿠키(브라우저 종료시 모두 종료)
//       //세션 관리자를 통해 세션을 생성하고, 회원 데이터 보관
//        sessionManager.createSession(member, response);
//
//        return "redirect:/";
//    }
    @PostMapping("/login")
    public String loginV3(@Valid @ModelAttribute LoginForm form, BindingResult
            bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }
        Member loginMember = loginService.login(form.getLoginId(),
                form.getPassword());
        log.info("login? {}", loginMember);
        if (loginMember == null) {
            return "login/loginError";
        }
        //로그인 성공 처리
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        return "redirect:/";
}
    @PostMapping("/logout")
    public String logoutV3(HttpServletRequest request) {
        //세션을 삭제한다.
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
