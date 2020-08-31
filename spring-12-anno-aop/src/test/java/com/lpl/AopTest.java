package com.lpl;

import com.lpl.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP配置
 */
public class AopTest {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        accountService.saveAccount();
        accountService.updateAccount(3);
        int i = accountService.deleteAccount();
    }
}
