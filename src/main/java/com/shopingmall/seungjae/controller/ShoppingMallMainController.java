package com.shopingmall.seungjae.controller;

import com.shopingmall.seungjae.controller.Member.SessionConst;
import com.shopingmall.seungjae.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j @RequiredArgsConstructor
public class ShoppingMallMainController {
//    @GetMapping("/")
//    public String homeLogin(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
//        log.info("memberId = {}",memberId);
//        if (memberId == null) {
//            log.info("memberId = Null");
//            return "main";
//        }
//        Member loginMember = memberRepository.findById(memberId);
//        if (loginMember == null) {
//            log.info("memberId = {}",memberId);
//            return "main";
//        }
//        model.addAttribute("member", loginMember);
//        return "loginHome";
//    }
//@GetMapping("/")
//public String homeLoginV2(HttpServletRequest request, Model model) {
//    //세션 관리자에 저장된 회원 정보 조회
//    Member member = (Member)sessionManager.getSession(request);
//    if (member == null) {
//        return "main";
//    }
//    //로그인
//    model.addAttribute("member", member);
//    return "loginHome";
//}

//    @GetMapping("/")
//    public String homeLoginV3(HttpServletRequest request, Model model) {
//        //세션이 없으면 home
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            return "main";
//        }
//        Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);
//        //세션에 회원 데이터가 없으면 home
//        if (loginMember == null) {
//            return "main";
//        }
//        //세션이 유지되면 로그인으로 이동
//        model.addAttribute("member", loginMember);
//        return "loginHome";
//    }
    @GetMapping("/")
    public String homeLoginV3(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
        //세션에 회원 데이터가 없으면 home
        if (loginMember == null) {
            return "main";
        }
        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}
