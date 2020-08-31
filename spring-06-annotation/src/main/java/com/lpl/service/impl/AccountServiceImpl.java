package com.lpl.service.impl;

import com.lpl.dao.IAccountDao;
import com.lpl.dao.impl.AccountDaoImpl;
import com.lpl.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 基于注解的配置（4类）：
 *      1.用于创建对象的：
 *          @Component：
 *              作用：用于把当前类对象放入Spring容器中。
 *              属性：
 *                  value：用于指定Bean的id，不写默认是当前类名的首字母小写。
 *          @Controller：一般用在表现层
 *          @Service：一般用在业务层
 *          @Repository：一般用在持久层
 *          以上三个注解的作用和属性与@Component注解一样
 *      2.用于注入数据的：
 *          @Autowired：
 *              作用：
 *                  按照类型注入（默认使用变量的名称加类型注入），只要容器中有唯一一个Bean对象的
 *                      类型与要注入的变量类型匹配，就可以注入成功。
 *                  注意：
 *                      如果容器中有多个类型匹配，而此时变量的名称又未与容器中所有此类型的名称匹配，就会注入失败！
 *                      如果容器中只有一个类型与要注入的类型匹配，则不管要注入类型的变量名称是否与
 *                          容器中类型名称相匹配，则都可以注入成功！
 *              出现位置：
 *                  可以是成员变量上，也可以是方法上。
 *          @Qualifier：
 *              作用：在按照类型的基础上再按照名称注入（实际上类型注入也可以通过变量名称来进行名称注入的）。它在给
 *                  类成员变量注入时不能单独使用，但在给方法参数注入时可以。
 *              属性：
 *                  value：用于指定注入时的id。
 *          @Resource：
 *              作用：按照Bean的id注入。
 *              属性：
 *                  name：指定Bean的id。
 *          以上三个注解均只能注入基本Bean类型数据，而基本类型和String类型无法注入。
 *          集合类型的注入只能通过XML的方式实现。
 *          @Value：
 *              作用：用于注入基本类型和String类型。
 *              属性：
 *                  value：用于指定数据的表达式，可以使用Spring的el表达式。SpEL表达式：${表达式}
 *      3.用于改变作用范围的：
 *          @Scope：
 *              用于指定Bean的作用范围。
 *              属性：
 *                  value：指定范围。常用属性：singleton（默认） prototype
 *      4.和声明周期相关的（了解）：
 *          @PreDestroy：
 *              作用：用于指定销毁方法。
 *          @PostConstructor：
 *              作用：用于指定初始化方法。
 */
@Component(value = "accountService")
//@Scope("prototype")

public class AccountServiceImpl implements IAccountService {

    //@Autowired
    //@Qualifier("accountDao2")
    @Resource(name = "accountDao2")
    private IAccountDao accountDao;

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl对象创建了！");
    }

    /**
     * 模拟保存账户
     */
    public void saveAccount() {
        accountDao.saveAccount();
    }
    /**
     * 初始化方法
     */
    @PostConstruct
    public void init(){
        System.out.println("执行了初始化方法！");
    }
    /**
     * 销毁方法
     */
    @PreDestroy
    public void destroy(){
        System.out.println("执行了销毁方法！");
    }
}
