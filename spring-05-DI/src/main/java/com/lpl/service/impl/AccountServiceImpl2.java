package com.lpl.service.impl;

import com.lpl.service.IAccountService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 账户的业务层实现类---演示Setter方法注入
 */
public class AccountServiceImpl2 implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
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
