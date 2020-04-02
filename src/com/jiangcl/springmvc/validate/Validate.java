package com.jiangcl.springmvc.validate;

import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangcl
 * @date 2020/1/14
 * @desc 对注解进行解析，并进行参数验证
 */
public class Validate<T> {

    public List<String> paramValidate(T t) throws Exception {
        List<String> errors = new ArrayList<>();

        Class clazz = t.getClass();
        //获取要校验实体的全部参数
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object obj = field.get(t);

            Valids valids = field.getDeclaredAnnotation(Valids.class);
            ParamValid[] paramValids = valids.value();
            for (ParamValid paramValid : paramValids) {
                System.out.println(paramValid.message());
            }

        }
        return null;
    }
}
