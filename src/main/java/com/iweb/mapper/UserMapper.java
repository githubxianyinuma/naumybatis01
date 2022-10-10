package com.iweb.mapper;
//所有关于mybaties的东西都在mapper包下
import com.iweb.Main;
import com.iweb.domain.User;
import com.iweb.domain.UserAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//这个文件为interface接口
public interface UserMapper {
    /**
     * 查询所有的用户表的信息
     */
    List<User> findAll();
    /**
     * 查询所有的用户表的信息
     */
    List<User> findAll1();
    /**
     * 查询所有的用户表的信息
     */
    List<User> findAll2();
    /**
     * 查询id为1的人的信息
     */
    //这里传参数查询人员id
    User findbyId(Integer id);
    /**
     * 通过多个id查询多个信息
     */
    List<User> findByIds(List<Integer> ids);
    /**
     * 插入一条数据,面向对象来说的话，相当于插入一个人进来，对于Java来说，相当于插入一个user对象
     */
    Integer add(User user);
    /**
     * 插入多条记录
     */
    Integer insetBatch(List<User> userList);
    /**
     * 根据id删除一条记录
     */
    Integer deleteById(Integer id);
    /**
     * 修改一条记录
     */
    Integer update(User user);
    /**
     * 修改一条记录升级版
     */
    Integer update1(User user);
    /**
     * 根据地址模糊查询(只有一个条件)
     * 因为是多个结果，所以用List数组
     */
    List<User> findUserByAddress(String address);
    /**
     * 根据地址和性别、年龄进行查询（多个条件）
     * 多种类型，SQL语句传参，则需要设置@parm注解
     */
    List<User> findUserByCondition(@Param("address") String address,
                                   @Param("sex") String sex,
                                   @Param("age") Integer age);
    /**
     * 根据地址和性别、年龄进行查询（多个条件）
     * 多种类型，SQL语句传参，则需要设置@parm注解
     * 动态SQL的if语句
     */
    List<User> findUserByCondition1(@Param("address") String address,
                                   @Param("sex") String sex,
                                   @Param("age") Integer age);
    /**
     * 根据地址和性别、年龄进行查询（多个条件）
     * 多种类型，SQL语句传参，则需要设置@parm注解
     * 动态SQL的where和if结合语句
     */
    List<User> findUserByCondition2(@Param("address") String address,
                                    @Param("sex") String sex,
                                    @Param("age") Integer age);
    /**
     * 查询总人数
     */
    Integer findSum();

    /**
     * 查询所有用户和账户表信息
     * 设计一个UserAccount
     */
    List<UserAccount> findAllUserAccount();
    /**
     * 查询所有用户和账户表信息
     * 以Map的形式返回
     */
    List<Map> findAllUserAccountMap();
    /**
     * 查询所有用户和账户表信息
     * 以mybaties定义的形式
     */
    List<User> findAllUsers();
}

