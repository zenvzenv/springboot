package com.zw.springboot.validata;

import com.zw.springboot.bean.CommonException;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 实体校验
 */
public class ValidateUtil {
    private static Validator validator =((HibernateValidatorConfiguration) Validation.byProvider(HibernateValidator .class).configure()).failFast(true).buildValidatorFactory().getValidator();
    public static <T> void validata(T obj) throws CommonException{
        Set<ConstraintViolation<T>> constraintViolations=validator.validate(obj, new Class[0]);
        if (constraintViolations.size()>0){
            ConstraintViolation<T> validateInfo=constraintViolations.iterator().next();
            throw new CommonException("0002",validateInfo.getMessage());
        }
    }
}
