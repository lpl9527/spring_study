package com.lpl.service.impl;

import com.lpl.service.IAccountService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 账户的业务层实现类    ---演示构造方法注入
 */
public class AccountServiceImpl implements IAccountService {

    /**
     * 对于经常变化的数据，并不适合此种注入方式
     */
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    /**
     * 模拟保存账户
     */
    public void saveAccount() {
        System.out.println("执行了账户保存操作！---" + "name=" + name
                + ",age=" + age
                + ",birthday=" + new SimpleDateFormat("yyyy-MM-dd").format(birthday));
    }

}
