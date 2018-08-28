package com.zw.springboot.config;

import com.zw.springboot.filter.CustomerFilter;
import com.zw.springboot.filter.ZwFilter;
import com.zw.springboot.listener.CustomListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.ServletRequestListener;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class Configration {
    /*@Bean
    public RegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        log.info("拦截器开始...");
        //当过滤器有注入到其他bean中，可直接通过@Bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
        //当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
        registrationBean.setFilter(customFilter());
        //设置过滤器名称
        registrationBean.setName("zwzw");
        //设置拦截路径
        List<String> urls=new ArrayList<>();
        urls.add("/zw");
        registrationBean.setUrlPatterns(urls);
        //设置顺序
        registrationBean.setOrder(2);
        log.info("拦截器结束");
        return registrationBean;
    }*/
    /*@Bean
    public Filter customFilter(){
        return new CustomerFilter();
    }
    @Bean
    public Filter zwFilter(){
        return new ZwFilter();
    }*/
    /*@Bean
    public ServletRequestListener customListener(){
        return new CustomListener();
    }*/
}
