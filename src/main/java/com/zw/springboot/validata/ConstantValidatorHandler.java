package com.zw.springboot.validata;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConstantValidatorHandler implements ConstraintValidator<Constant,String> {
    private String constant;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //判断参数是否等于设置的字段值，返回结果
        return constant.equals(s);
    }

    @Override
    public void initialize(Constant constraintAnnotation) {
        //获取设置的字段值
        this.constant=constraintAnnotation.toString();
    }
}
