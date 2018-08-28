package com.zw.springboot.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "zwFilter",urlPatterns = {"/zw"})
public class ZwFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("zw 拦截器启动...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截到zw请求");
        servletResponse.setCharacterEncoding("utf-8");
        servletRequest.getRequestDispatcher("/hello").forward(servletRequest,servletResponse);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("销毁 zw拦截器");
    }
}
