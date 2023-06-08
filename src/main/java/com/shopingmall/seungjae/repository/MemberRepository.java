package com.shopingmall.seungjae.repository;

import com.shopingmall.seungjae.domain.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);//저장소에 저장하기
    Optional<Member> findPasswordByIdName(String id, String Name);//id로 찾기 비밀번호를 분실했을 때

}
