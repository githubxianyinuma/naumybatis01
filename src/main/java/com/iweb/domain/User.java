package com.iweb.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 构造方法：constroct   有参和无参
 * get和set
 * equals和hashcode
 * toString
 */
public class User implements Serializable {
    //序列化的ID，系统可以默认生成
    private static final long serialVersionUID = -6849794470754667710L;

    private Integer id;//用户id
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private Integer age;
    private String guojia;

    private List<Account> accountList;//一个用户可能有多张卡

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", guojia='" + guojia + '\'' +
                ", accountList=" + accountList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (guojia != null ? !guojia.equals(user.guojia) : user.guojia != null) return false;
        return accountList != null ? accountList.equals(user.accountList) : user.accountList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (guojia != null ? guojia.hashCode() : 0);
        result = 31 * result + (accountList != null ? accountList.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGuojia() {
        return guojia;
    }

    public void setGuojia(String guojia) {
        this.guojia = guojia;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public User() {
    }

    public User(Integer id, String username, Date birthday, String sex, String address, Integer age, String guojia, List<Account> accountList) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.age = age;
        this.guojia = guojia;
        this.accountList = accountList;
    }
}
