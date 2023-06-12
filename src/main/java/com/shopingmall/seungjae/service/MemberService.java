package com.shopingmall.seungjae.service;


import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;


@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member) {
        //같은 이름이 있는 중복 회원은 안된다.
        memberRepository.findPasswordById(member.getId())
                .ifPresent(m->{
                    throw new IllegalStateException();
                });

        memberRepository.save(member); //저장
        return member.getId();
    }
//    public String isPresent(Member member){
//        memberRepository.findPasswordById(member.getId())
//                .ifPresent(m->{
//                    try {
//                        throw new IllegalAccessException();
//                    } catch (IllegalAccessException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//    }
}
