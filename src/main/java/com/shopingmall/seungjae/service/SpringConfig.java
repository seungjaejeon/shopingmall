package com.shopingmall.seungjae.service;

import com.shopingmall.seungjae.interceptor.LogInterceptor;
import com.shopingmall.seungjae.interceptor.LoginCheckInterceptor;
import com.shopingmall.seungjae.repository.*;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {
    EntityManager em;
    public SpringConfig(EntityManager em){
        this.em = em;
    }
    @Bean
    public MemberRepository memberRepository(){return new JpaMemberRepository(em);
    }
    @Bean
    public ItemRepository itemRepository(){
        return new ItemRepositoryImpl();
    }

/*
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
*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/error"); //인터셉터 호출 안되는 URL

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/member/**");
    }
}
