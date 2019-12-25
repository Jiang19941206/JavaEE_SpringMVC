package com.jiangcl.springmvc.demo;

/**
 * @author jiangcl
 * @date 2019/12/25
 * @desc 定义一个实体类
 */
public class UserDomain {
    private String userName;

    private String password;

    private Integer age;

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

    @Override
    public String toString() {
        return "UserDomain{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
