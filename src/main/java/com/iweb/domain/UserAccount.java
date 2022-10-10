package com.iweb.domain;

import java.util.Date;

/**
 * 用户账户信息表
 */
public class UserAccount {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private Integer age;
    private String guojia;

    private Integer accountid;//卡的id
    private Integer money;

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", guojia='" + guojia + '\'' +
                ", accountid=" + accountid +
                ", money=" + money +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccount that = (UserAccount) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (guojia != null ? !guojia.equals(that.guojia) : that.guojia != null) return false;
        if (accountid != null ? !accountid.equals(that.accountid) : that.accountid != null) return false;
        return money != null ? money.equals(that.money) : that.money == null;
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
        result = 31 * result + (accountid != null ? accountid.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
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

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public UserAccount() {
    }

    public UserAccount(Integer id, String username, Date birthday, String sex, String address, Integer age, String guojia, Integer accountid, Integer money) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.age = age;
        this.guojia = guojia;
        this.accountid = accountid;
        this.money = money;
    }
}
