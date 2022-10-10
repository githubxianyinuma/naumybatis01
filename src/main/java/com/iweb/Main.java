package com.iweb;

import com.iweb.domain.User;
import com.iweb.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] str = {"东京","北京","南京","西京"};
//        普通for循环
//        for (int i = 0; i < str.length; i++) {
//            System.out.println(str[i]);
//        }
//        增强for循环(foreach循环)
        for (String s:str) {
            System.out.println(s);
        }

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        //普通for循环
//        for (int i = 0; i < ints.size(); i++) {
//            System.out.println(ints.get(i));
//        }
        //增强for循环
        for (Integer i:ints) {
            System.out.println(i);
        }
        //HashMap用来存储键值对
        HashMap hashMap = new HashMap();
        hashMap.put("山东省","临沂市");
        hashMap.put("江苏省","南京市");
        hashMap.put("西藏自治区","拉萨市");
        hashMap.put("安徽省","合肥市");
        hashMap.put("四川省","成都市");
        System.out.println(hashMap);
//        String resource = "mybatis-config.xml";
//        //读取配置文件，放到一个inputStream流中
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        //构建一个SqlSessionFactoryBuilder
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        //利用这个sqlSessionFactoryBuilder，生成sqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
//        //利用sqlSessionFactory工厂生成SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //通过sqlSession，可以获取指定的接口的mapper,获取到的userMapper 是一个实现类
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

//        List<User> userList = userMapper.findAll();
//        System.out.println(userList);

//        User user = userMapper.findbyId(1);
//        System.out.println(user);

    }
}
