package com.zw.springboot.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//注册名为CustomerFilter的拦截器，拦截路径是所有路径
@Slf4j
@WebFilter(filterName = "customerFilter",urlPatterns = {"/*"})
@Order(value = 1)
public class CustomerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter开始处理请求...");
        //对request和response进行预处理请求
        //比如设置请求编码
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        //进行业务处理

        //链路 直接传给下一个过滤器
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("filter销毁");
    }
}
