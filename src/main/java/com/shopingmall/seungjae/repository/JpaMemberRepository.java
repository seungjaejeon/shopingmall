package com.shopingmall.seungjae.repository;

import com.shopingmall.seungjae.domain.Member;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository {
    private final EntityManager em;
    @Autowired
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        // 엔티티를 영속화하여 데이터베이스에 저장하는 메서드.
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        // 로그인 아이디(loginId)를 기반으로 회원을 조회하는 메서드.
        // JPQL을 사용하여 쿼리를 작성하고, 파라미터로 넘어온 loginId를 바인딩.
        // 조회 결과를 리스트로 가져온 뒤 첫 번째 요소를 Optional로 감싸서 반환.
        Optional<Member> member = em.createQuery("select m from Member m where m.loginId = :loginId", Member.class)
                .setParameter("loginId", loginId)
                .getResultList()
                .stream().findFirst();
        return member;
    }

    @Override
    public Member findById(Long id) {
        // 주어진 아이디(id)를 사용하여 회원을 조회하는 메서드
        // EntityManager의 find 메서드를 사용하여 엔티티를 조회
        Member member = em.find(Member.class, id);
        return member;
    }

    @Override
    public List<Member> findAll() {
        // 모든 회원을 조회하는 메서드.
        // JPQL을 사용하여 모든 Member 엔티티를 가져옴
        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return members;
    }
}
