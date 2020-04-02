package com.jiangcl.springmvc.validate;

import java.lang.annotation.*;

/**
 * @author jiangcl
 * @date 2020/1/14
 * @desc 参数校验注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface ParamValid {
    String message() default "";
    String regex() default "";
    Type type() default Type.NOT_NULL;
    int min() default 0;
    int max() default 2147483647;
}
