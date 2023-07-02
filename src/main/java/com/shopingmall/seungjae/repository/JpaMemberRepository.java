//package com.shopingmall.seungjae.repository;
//
//import com.shopingmall.seungjae.domain.Member;
//import jakarta.persistence.EntityManager;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class JpaMemberRepository implements MemberRepository{
//
//    private final EntityManager em;
//    public JpaMemberRepository(EntityManager em){
//        this.em = em;
//    }
//    @Override
//    public Member save(Member member) {
//        em.persist(member);
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findByLoginId(String id) {
//        Member member = em.find(Member.class, id);
//        return Optional.ofNullable(member);
//    }
//
//    @Override
//    public Member findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return null;
//    }
//
//    @Override
//    public void clearStore() {
//
//    }
//
//}
