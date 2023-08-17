package com.shopingmall.seungjae.service;


import com.shopingmall.seungjae.domain.Basket;
import com.shopingmall.seungjae.domain.Member;
import com.shopingmall.seungjae.repository.Basket.BasketRepository;
import com.shopingmall.seungjae.repository.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor @Service @Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final BasketRepository basketRepository;
    public String join(Member member) {
        //같은 이름이 있는 중복 회원은 안된다.
        memberRepository.findByLoginId(member.getLoginId())
                .ifPresent(m->{
                    throw new IllegalStateException();
                });
        memberRepository.save(member); //저장

        Basket basket = Basket.createBasket(member);
        basketRepository.save(basket);

        return member.getLoginId();
    }
}
