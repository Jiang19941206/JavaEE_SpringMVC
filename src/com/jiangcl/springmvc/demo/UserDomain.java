package com.jiangcl.springmvc.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author jiangcl
 * @date 2019/12/25
 * @desc 定义一个实体类
 */
public class UserDomain {
    private String userName;

    private String password;

    private Integer age;

    //将前端传过来的字符串转换为日期格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthDay;

    private Address address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //使用注解格式化日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "UserDomain{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                ", address=" + address +
                '}';
    }
}
