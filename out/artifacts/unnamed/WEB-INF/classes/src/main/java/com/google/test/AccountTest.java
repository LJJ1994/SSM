package com.google.test;

import com.google.domain.Account;
import com.google.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    @Test
    public void TestRun(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.findAll();
    }
}
