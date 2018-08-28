package com.zw.springboot.validata;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
//指定注解的处理类
@Constraint(validatedBy = {ConstantValidatorHandler.class})
@Target({ElementType.METHOD, ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Constant {
    String message() default "{constraint.default.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value();
}
