package com.shopingmall.seungjae.service;

import com.shopingmall.seungjae.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class SessionManagerTest {
    SessionManager sessionManager = new SessionManager();
    @Test
    void sessionTest() {
        //세션 생성
        MockHttpServletResponse response = new MockHttpServletResponse();
/*        간단하게 테스트를 진행해보자. 여기서는 HttpServletRequest , HttpservletResponse 객체를 직접
        사용할 수 없기 때문에 테스트에서 비슷한 역할을 해주는 가짜 MockHttpServletRequest ,
        MockHttpServletResponse 를 사용했다.*/
        Member member = new Member();
        sessionManager.createSession(member, response);
        //요청에 응답 쿠키 저장
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());
        //세션 조회
        Object result = sessionManager.getSession(request);
        assertThat(result).isEqualTo(member);
        //세션 만료
        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);
        assertThat(expired).isNull();
    }
}