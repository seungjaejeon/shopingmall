package com.shopingmall.seungjae.controller.Member;

import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j @RequestMapping("member/signup") @RequiredArgsConstructor
public class ShoppingMallMemberJoinController {
    private final MemberService memberService;
    @GetMapping
    public String JoinPage(@ModelAttribute Member member, Model model){
        model.addAttribute("member", member);
        return "member/join/joinPage";
    }

    @PostMapping
    public String CreateMember(@ModelAttribute Member member, BindingResult bindingResult){
        //검증
        if(!StringUtils.hasText(member.getName())){
            bindingResult.addError(new FieldError("member", "name", "문자를 적으셔야 합니다."));
        }
        if(!StringUtils.hasText(member.getLoginId())||member.getLoginId().length()<3||member.getLoginId().length()>10){
            bindingResult.addError(new FieldError("member", "loginId", "올바르지 않은 ID: 문자가 있어야하고 아이디의 길이는 3자 이상 10자 이하여야 합니다."));
        }
        if(member.getPassword().length()<3||member.getPassword().length()>10){
            bindingResult.addError(new FieldError("member", "password", "올바르지 않은 PASSWORD: 비밀번호의 길이는 3자 이상 10자 이하여야 합니다."));
        }
        if(bindingResult.hasErrors()){
            log.info("bindingResult = {}", bindingResult);
            return "member/join/joinPage";
        }
        memberService.join(member);
        log.info("member={}", member);
        return "redirect:/";
    }

    @ExceptionHandler(IllegalStateException.class)
    public String JoinError() {
        return "member/join/joinError";
    }
}
