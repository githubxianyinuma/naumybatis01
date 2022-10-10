package com.iweb;

import com.iweb.domain.Account;
import com.iweb.domain.User;
import com.iweb.domain.UserAccount;
import com.iweb.mapper.AccountMapper;
import com.iweb.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    /**
     * 在测试运行之前，就要先执行的代码
     */
    //将其作为全局变量，在@before调用
    UserMapper userMapper = null;
    SqlSession sqlSession = null;
    AccountMapper accountMapper = null;
    SqlSessionFactory sqlSessionFactory = null;

    /**
     *所有test的共有文件，放在@before
     */
    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        //读取配置文件，放到一个inputStream流中
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //建一个SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //利用这个sqlSessionFactoryBuilder，生成sqlSessionFactory
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //利用sqlSessionFactory工厂生成SqlSession
        sqlSession = sqlSessionFactory.openSession();
//        这里将SQL提交设置为自动提交，无需重现手动提交
//        sqlSession = sqlSessionFactory.openSession(true);
        //通过sqlSession，可以获取指定的接口的mapper,获取到的userMapper 是一个实现类
       userMapper = sqlSession.getMapper(UserMapper.class);
       accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    /**
     * 查询所有用户
     * @throws IOException
     */
    @Test
    public void findAll() throws IOException {
        List<User> userList = userMapper.findAll();
        System.out.println(userList);
    }
    /**
     * 查询所有用户
     * @throws IOException
     */
    @Test
    public void findAll1(){
        List<User> all1 = userMapper.findAll1();
        System.out.println(all1);
    }
    /**
     * 查询所有用户
     * @throws IOException
     */
    @Test
    public void findAll2(){
        List<User> all2 = userMapper.findAll2();
        System.out.println(all2);
    }
    /**
     * 根据id查询一个用户的信息
     */
    @Test
    public void findById() throws IOException {

        User user = userMapper.findbyId(1);
        System.out.println(user);
    }

    /**
     * 通过多个id查询多个信息
     */
    @Test
    public void findByIds(){
//        这里使用的多态
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(6);
        if (ids.size() < 1) {
            System.out.println("查询不到值，因为集合是空的");
        }
        else {
            List<User> userList = userMapper.findByIds(ids);
            System.out.println(userList);
        }
    }
    /**
     * 插入一条记录
     */
    @Test
    public void add(){
        User user = new User();
        user.setUsername("殷素素");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("魔教天鹰派");

        Integer add = userMapper.add(user);
        System.out.println(add);
    }
    /**
     * 插入多条记录
     */
    @Test
    public void insetBatch(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUsername("zhangsan"+i);
            user.setBirthday(new Date());
            user.setSex("男");
            user.setAddress("北京");
            user.setAge(19);
            userList.add(user);
        }
        userMapper.insetBatch(userList);
        System.out.println(userList);
    }
    /**
     * 删除一条记录
     */
    @Test
    public void deleteById(){
        Integer integer = userMapper.deleteById(4);
        System.out.println(integer);
    }

    /**
     * 修改一条记录
     */
    @Test
    public void update() throws ParseException {
        //这种修改记录的方法存在问题，null, 1500-10-11 00:00:00.0(Timestamp), null, 一苇渡江(String), 2(Integer)会将姓名和性别置空
//        User user = new User();
//        user.setId(2);
//        user.setAddress("一苇渡江");
//        user.setBirthday(stringToDate("1500-10-11"));
        //建议先查后改，查出来用户后修改，乐观锁
        User user = userMapper.findbyId(2);
        System.out.println("修改之前的："+user);
        user.setBirthday(stringToDate("1500-11-20"));
        user.setAddress("一苇渡江");
        System.out.println("修改之后的："+user);

        Integer update = userMapper.update(user);
        System.out.println(update);
    }
    /**
     * 修改一条记录升级版
     */
    @Test
    public void update1() throws ParseException {
        //这种修改记录的方法存在问题，null, 1500-10-11 00:00:00.0(Timestamp), null, 一苇渡江(String), 2(Integer)会将姓名和性别置空
        User user = new User();
        user.setId(2);
        user.setAddress("一苇渡江");
        user.setBirthday(stringToDate("1500-10-11"));
        //建议先查后改，查出来用户后修改，乐观锁
//        User user = userMapper.findbyId(2);
//        System.out.println("修改之前的："+user);
//        user.setBirthday(stringToDate("1500-11-20"));
//        user.setAddress("一苇渡江");
//        System.out.println("修改之后的："+user);

        Integer update = userMapper.update1(user);
        System.out.println(update);
    }
    //日期与String的转换，写一个方法
    public Date stringToDate(String str) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = df.parse(str);
        return parse;
    }

    /**
     * 根据地址模糊查询
     */
    @Test
    public void findUserByAddress(){
        //这里模糊查询要和SQL语句一样使用%匹配字符，_下划线表示匹配一个字符，%表示后面匹配0-N个字符
        List<User> userList = userMapper.findUserByAddress("_苇%");
        System.out.println(userList);
    }

    @Test
    public void findUserByConition(){
        List<User> userList = userMapper.findUserByCondition("%岛%", "女", 50);
        System.out.println(userList);
    }

    /**
     * 动态SQL的if语句
     */
    @Test
    public void findUserByCondition1(){
        List<User> userList = userMapper.findUserByCondition1(null,"男",50);
        System.out.println(userList);
    }

    /**
     * 动态SQL的where和if结合的语句
     */
    @Test
    public void findUserByCondition2(){
        List<User> userList = userMapper.findUserByCondition2(null,"男",50);
        System.out.println(userList);
    }

    @Test
    public void findCount(){
        Integer sum = userMapper.findSum();
        System.out.println("总人数为"+sum);
    }
    /**
     * 两张表，查询所有用户和账户表信息（方法一）
     */
    @Test
    public void findAllUserAccount(){
        List<UserAccount> allUserAccount = userMapper.findAllUserAccount();
        System.out.println(allUserAccount);
    }
    /**
     * 两张表，查询所有用户和账户表信息（方法二），设计一个HashMap
     * 这里发现输出的结果是无序的，因为HashMap是无序存储
     */
    @Test
    public void findAllUserAccountMap(){
        List<Map> aLlUserAccountMap = userMapper.findAllUserAccountMap();
        System.out.println(aLlUserAccountMap);
    }
    /**
     * 两张表，查询所有用户和账户表信息（方法三），设计list数组对应,解决一对多的问题
     */
    @Test
    public void findAllUser(){
        List<User> allUsers = userMapper.findAllUsers();
        System.out.println(allUsers);
    }

    /**
     * 通过卡确定人
     */
    @Test
    public void findAllAccounts(){
        List<Account> accounts = accountMapper.selectAllAccount();
        System.out.println(accounts);
    }

    /**
     * 证明mybaties查询数据库使用一级缓存（默认开启）
     * 且缓存数据是存在内存中的
     * 可能会失效，一种是sqlsession关闭了之后，再开；二是数据库表有变动（如更新-删除-修改），必须失效；还有就是主动清理缓存
     */
    @Test
    public void findAllcathes(){
        List<User> all = userMapper.findAll();
        System.out.println(all);
//        //关闭sqlsession，是否失效,再打开
//        sqlSession.close();
//        sqlSession = sqlSessionFactory.openSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> all1 = mapper.findAll();
        //sqlsession清理缓存
        sqlSession.clearCache();
        List<User> all1 = userMapper.findAll();
        System.out.println(all1);
        //equals证明值相等
        System.out.println(all.equals(all1));
        //==证明完全相同，内存地址也一样
        System.out.println(all == all1);
    }

    /**
     * mybaties二级缓存默认不开启，需要手工开启
     * 且缓存数据存储在硬盘上
     * sqlsession关闭之后，缓存的数据还在，数据对象不一样，但是内容一样
     * 失效的条件：一是数据库表有变动；二是清理缓存
     * 这里注意，要使用二级缓存，实体类必须序列化（序列化的意思是一个实体类的对象必须存在硬盘上）
     */
    @Test
    public void findAllCache(){
        User user = userMapper.findbyId(1);
        System.out.println(user);
        //关闭sqlsession，是否失效,再打开
        sqlSession.close();
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.findbyId(1);
        //User user1 = userMapper.findbyId(1);
        System.out.println(user1);
        //==证明完全相同，内存地址也一样
        System.out.println(user == user1);
    }
    @After
    public void after(){
        //Mybaties事务，意思是手工提交SQL代码，防止出现回滚Rolling back现象
        sqlSession.commit();
        sqlSession.close();
    }
}
