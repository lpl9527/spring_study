package com.lpl.jdbctemplate;

import com.lpl.bean.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * jdbctemplate的CRUD操作
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        //保存
        //jdbcTemplate.update("insert into account(name, money) values(?, ?)", "李太白", 200);
        //更新
        //jdbcTemplate.update("update account set name=?, money=? where id=?", "李太白2", 400, 5);
        //删除
        //jdbcTemplate.update("delete from account where id = ?", 7);
        //查询所有
        List<Account> accounts = jdbcTemplate.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 200);
        for (Account account : accounts){
            System.out.println(account);
        }
        //查询一个
        List<Account> accountList = jdbcTemplate.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class),6);
        Account account = accountList.isEmpty()?null:accountList.get(0);
        System.out.println("==========" + account);
        //查询返回一行一列
        Integer count = jdbcTemplate.queryForObject("select count(*) from account where money > ?", Integer.class, 400);
        System.out.println("查询条数： " + count);
    }
}
