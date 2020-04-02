package com.jiangcl.springmvc.validate;

/**
 * @author jiangcl
 * @date 2020/1/14
 * @desc
 */
public class PDomain {

    @Valids(value = {
            @ParamValid(message = ""),
            @ParamValid()
    })
    private String userName;

    @ParamValid(message = "this is age")
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
