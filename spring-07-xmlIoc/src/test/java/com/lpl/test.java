package com.lpl;

import com.lpl.bean.Account;
import com.lpl.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 测试类
 */
public class test {

    /**
     * 查询所有账户测试
     */
    @Test
    public void findAllTest(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        List<Account> accounts = accountService.findAll();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    /**
     * 根据id查询账户测试
     */
    @Test
    public void findByIdTest(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        Account account = accountService.findById(3);
        System.out.println(account);
    }
    /**
     * 保存账户测试
     */
    @Test
    public void saveAccountTest(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        Account account = new Account();
        account.setUid(4);
        account.setMoney(3456.2f);
        accountService.saveAccount(account);
    }
    /**
     * 测试更新账户
     */
    @Test
    public void updateAccountTest(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        Account account = new Account();
        account.setId(4);
        account.setUid(52);
        account.setMoney(2345.67f);
        accountService.updateAccount(account);
    }
    /**
     *  测试删除账户
     */
    @Test
    public void deleteAccountTest(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        accountService.deleteAccount(4);
    }
}
