package com.lpl.jdbctemplate;

import com.lpl.bean.Account;
import com.lpl.dao.IAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * jdbctemplate的CRUD操作
 */
public class JdbcTemplateDemo4 {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);

        //Account account = accountDao.findAccountById(6);
        Account account = accountDao.findAccountByName("斑斑6号");
        System.out.println("更新前： " + account);
        account.setMoney(600f);
        accountDao.updateAccount(account);
        System.out.println("更新后： " + account);

    }
}
