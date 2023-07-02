package com.shopingmall.seungjae.service;


import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor @Service
public class MemberService {

    private final MemberRepository memberRepository;

    public String join(Member member) {
        //같은 이름이 있는 중복 회원은 안된다.
        memberRepository.findByLoginId(member.getLoginId())
                .ifPresent(m->{
                    throw new IllegalStateException();
                });

        memberRepository.save(member); //저장
        return member.getLoginId();
    }
}
