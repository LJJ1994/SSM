package com.google.test;

import com.google.dao.AccountDao;
import com.google.domain.Account;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void testFindAll() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession对象
        SqlSession session = factory.openSession();
        // 获取代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        List<Account> accountList = accountDao.findAll();
        for(Account account : accountList) {
            System.out.println(account.getName());;
        }
        session.close();
        in.close();
    }

    @Test
    public void testSaveAccount() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession对象
        SqlSession session = factory.openSession();
        // 获取代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);

        Account account = new Account();
        account.setName("hlp");
        account.setMoney(1000.2);
        accountDao.saveAccount(account);
        session.commit();
        session.close();
        in.close();
    }
}
