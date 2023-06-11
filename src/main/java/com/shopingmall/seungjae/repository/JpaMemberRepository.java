package com.shopingmall.seungjae.repository;

import com.shopingmall.seungjae.domain.Member;

import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findPasswordByIdName(String id, String Name) {
        return Optional.empty();
    }
}
