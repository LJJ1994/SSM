package com.google.dao;

import com.google.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {
    /**
     * 查询所有账户
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     * 保存账户
     */
    @Insert(value = "insert into account (name, money) values(#{name}, #{money}) ")
    public void saveAccount(Account account);
}
