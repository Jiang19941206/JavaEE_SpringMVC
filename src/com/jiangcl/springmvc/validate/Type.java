package com.jiangcl.springmvc.validate;

/**
 * @author jiangcl
 * @date 2020/1/14
 * @desc 验证类型
 */
public enum Type {
    NOT_NULL("not_null"),

    SIZE("size"),

    REGEX("regex");

    private String value;

    Type(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
