package com.zw.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@MapperScan("com.zw.bean")
//@EnableTransactionManagement
@ImportResource(locations = {"classpath:/mybatis/spring-mybatis.xml"})
public class MybatisPlusConfig {

}
