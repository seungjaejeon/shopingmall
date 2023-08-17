package com.shopingmall.seungjae.service;

import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.repository.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public Member login(String loginId, String password) {
        Optional<Member> member = memberRepository.findByLoginId(loginId);
        return member.filter(m -> m.getPassword().equals(password)).orElse(null);
    }
}
