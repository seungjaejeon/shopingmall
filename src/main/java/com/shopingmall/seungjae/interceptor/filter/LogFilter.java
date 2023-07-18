package com.shopingmall.seungjae.interceptor.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("log filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("log filter doFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();
        String uuid = UUID.randomUUID().toString();
        try {
            log.info("request [{}][{}] ", uuid, requestURI);
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw e;
        }
        finally {
            log.info("response [{}][{}]", uuid,requestURI);
        }
    }

    @Override
    public void destroy() {
        log.info("log filter destroy");
        Filter.super.destroy();

    }
}
