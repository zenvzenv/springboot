package com.zw.springboot.controller;

import com.zw.springboot.bean.CommonException;
import com.zw.springboot.bean.ReqBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@RestController
public class ZwController {
    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello World!";
    }
    @GetMapping(value = "/zw")
    public String zw(){
        return "zw zw";
    }
    @GetMapping("/demo")
    public String demo(){
        int i=1/0;
        return "exception";
    }
    /**
     * 异常处理
     */
    @GetMapping("/exception/{type}")
    public ModelAndView exception(@PathVariable(value = "type") String type) throws Exception{
        if ("error".equals(type)){
            throw new CommonException("9999","zw_error");
        }else if ("io_error".equals(type)){
            throw new IOException();
        }else {
            return new ModelAndView("index").addObject("msg",type);
        }
    }
    /**
     * 数据校验
     */
    @GetMapping("/valid")
    public String valid(@Valid ReqBean reqBean){
        return reqBean.getName()+" , "+reqBean.getCode()+" , "+reqBean.getVersion();
    }
}
