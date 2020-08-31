package com.lpl;

import com.lpl.bean.Account;
import com.lpl.config.SpringConfiguration;
import com.lpl.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试类
 * Spring整合junit的配置：
 *  1.导入spring整合junit的依赖；
 *  2.使用junit提供的注解将原有的main（程序入口方法）方法替换成spring提供的；
 *      @Runwith
 *  3.告知spring的运行器，spring的ioc创建是基于xml还是注解的，并且说明位置。
 *      @ContextConfiguration
 *          属性：
 *              location：指定xml文件的位置，加上classpath
 *              classes：指定注解类所在的字节码文件
 *  注意：当使用spring 5.x版本时，要求junit的jar必须在4.12以上。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class test {

    /**
     * 由于spring整合了junit，则容器中的相关对象可以直接进行注入，不需要再手动读取配置文件。
     */
    @Autowired
    private IAccountService accountService;

    /**
     * 查询所有账户测试
     */
    @Test
    public void findAllTest(){
        //1.获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //读取配置的配置类
        //ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2.得到业务层对象
        //IAccountService accountService = ac.getBean("accountService", IAccountService.class);
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
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //读取配置的配置类
        //ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2.得到业务层对象
        //IAccountService accountService = ac.getBean("accountService", IAccountService.class);
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
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //读取配置的配置类
        //ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2.得到业务层对象
        //IAccountService accountService = ac.getBean("accountService", IAccountService.class);
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
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //读取配置的配置类
        //ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2.得到业务层对象
        //IAccountService accountService = ac.getBean("accountService", IAccountService.class);
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
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //读取配置的配置类
        //ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2.得到业务层对象
        //IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        accountService.deleteAccount(5);
    }
}
