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

    /**
     * 核心容器中的两个接口：
     *  ApplicationContext:
     *      它在构建容器时，创建对象采取的策略是立即加载的方式，只要一读取完配置立即就创建配置文件文件中配置的对象
     *  BeanFactory:
     *      它在构建容器时，创建对象采用的策略是延迟加载的方式，什么时候根据id获取对象，什么时候才会创建对象
     */
    public static void main(String[] args) {

        /**
         * 获取Spring的IOC核心容器，并从容器中根据Id获取对象
         */
        //-----------------------ApplicationContext------------------------
        //1.获取核心容器对象    单例对象适用
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取对象    多例对象适用
        IAccountService accountService  = ac.getBean("accountService", IAccountService.class);

        //保存账户
        accountService.saveAccount();

        //------------------------BeanFactory---------------------------------
        /*Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as = factory.getBean("accountService", IAccountService.class);
        System.out.println(as);*/

    }
}
