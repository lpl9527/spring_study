package com.lpl.ui;

import com.lpl.service.IAccountService;
import com.lpl.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {

        /**
         * 获取Spring的IOC核心容器，并从容器中根据Id获取对象
         */
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取对象
        IAccountService accountService  = ac.getBean("accountService3", IAccountService.class);
        //保存账户
        accountService.saveAccount();

    }
}
