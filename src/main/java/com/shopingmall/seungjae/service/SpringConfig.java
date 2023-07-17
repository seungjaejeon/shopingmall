package com.shopingmall.seungjae.service;

import com.shopingmall.seungjae.filter.LogFilter;
import com.shopingmall.seungjae.filter.LoginCheckFilter;
import com.shopingmall.seungjae.repository.ItemRepository;
import com.shopingmall.seungjae.repository.ItemRepositoryImpl;
import com.shopingmall.seungjae.repository.MemberRepository;
import com.shopingmall.seungjae.repository.MemberRepositoryImpl;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
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
    @Bean
    public ItemRepository itemRepository(){
        return new ItemRepositoryImpl();
    }

    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean loginCheckFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginCheckFilter());
        filterRegistrationBean.setOrder(2); //filter 순서
        filterRegistrationBean.addUrlPatterns("/*"); //doFilter 실행할 URL 설정
        return filterRegistrationBean;
    }


}
