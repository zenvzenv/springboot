package com.zw.springboot.exception;

import com.zw.springboot.bean.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice//增强控制器，使@ExceptionHandler,@InitBinder,@ModelAttribute注解的方法应用到所有的@RequestMapping注解的方法
@Slf4j
public class CommonExceptionHandle {
    /**
     * 拦截Exception类的异常
     * @param e
     * @return
     */
    @ExceptionHandler//异常处理器，此注解的作用是当出现定义的异常时进行处理
    @ResponseBody
    public Map<String,Object> exceptionHandle(Exception e){
        Map<String,Object> result=new HashMap<>();
        result.put("respCode","6666");
        result.put("respMsg",e.getMessage());
        return result;
    }
    @ExceptionHandler(CommonException.class)//可以直接写@ExceptionHandler,不指明异常类，会自动映射
    @ResponseBody
    public Map<String,Object> exceptionHandler(CommonException ex){
        ex.toString();
        log.info("CommonException:{}({})",ex.getMsg(),ex.getCode());
        Map<String,Object> result=new HashMap<>();
        result.put("respMsg",ex.getCode());
        result.put("respCode",ex.getCode());
        return result;
    }
    /*@ExceptionHandler(CommonException.class)
    public ModelAndView exception(CommonException ex){
        ModelAndView mv=new ModelAndView();
        mv.addObject("respMsg",ex.getMsg());
        mv.addObject("respCode",ex.getCode());
        return mv;
    }*/
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String,Object> handlerBindException(MethodArgumentNotValidException ex){
        FieldError fieldError=ex.getBindingResult().getFieldError();
        log.info("参数校验异常:{}({})",fieldError.getDefaultMessage(),fieldError.getField());
        Map<String,Object> result=new HashMap<>();
        result.put("respCode","0003");
        result.put("respMsg",fieldError.getDefaultMessage());
        return result;
    }
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Map<String,Object> handlerBindException(BindException ex){
        //校验除了requestbody注解方式的参数校验对应的bindingresult为BeanPropertyBindResult
        FieldError fieldError=ex.getBindingResult().getFieldError();
        log.info("必填检验异常{}({})",fieldError.getDefaultMessage(),fieldError.getField());
        Map<String,Object> result=new HashMap<>();
        result.put("respCode","0004");
        result.put("respMsg",fieldError.getDefaultMessage());
        return result;
    }
}
