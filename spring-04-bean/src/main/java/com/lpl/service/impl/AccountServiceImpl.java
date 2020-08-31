package com.lpl.service.impl;

import com.lpl.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    /**
     * 构造函数
     */
    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl对象创建了！");
    }
    /**
     * 模拟保存账户
     */
    public void saveAccount() {
        System.out.println("执行了账户保存操作！");
    }
    /**
     * 初始化方法
     */
    public void init(){
        System.out.println("对象初始化了！");
    }
    /**
     * 销毁方法
     */
    public void destroy(){
        System.out.println("对象销毁了！");
    }

}
