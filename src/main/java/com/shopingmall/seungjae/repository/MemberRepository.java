package com.shopingmall.seungjae.repository;

import com.shopingmall.seungjae.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository {
    public Member save(Member member);//저장소에 저장하기
    public Optional<Member> findByLoginId(String id);//LoginId로 찾기 비밀번호를 분실했을 때

    public Member findById(Long id);

    public List<Member> findAll();
    public void clearStore();
}
