package com.jiangcl.springmvc.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jiangcl
 * @date 2020/1/14
 * @desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Valids {
    ParamValid[] value() default {@ParamValid};
}
