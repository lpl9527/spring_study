package com.lpl.ui;

import com.lpl.factory.BeanFactory;
import com.lpl.service.IAccountService;

/**
 * 模拟表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {

        //IAccountService accountService = new AccountServiceImpl();
        for(int i=0; i<5; i++){
            //降低耦合，使用Bean工厂创建所需Bean对象
            IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService);
            //保存账户
            accountService.saveAccount();
        }

    }
}
