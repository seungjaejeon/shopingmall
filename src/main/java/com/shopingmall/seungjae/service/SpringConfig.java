package com.shopingmall.seungjae.service;

import com.shopingmall.seungjae.repository.MemberRepository;
import com.shopingmall.seungjae.repository.MemberRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//    EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }
    @Bean
    public MemberRepository memberRepository(){return new MemberRepositoryImpl();
    }

}
