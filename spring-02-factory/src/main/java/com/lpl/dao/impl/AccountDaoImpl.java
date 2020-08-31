package com.lpl.dao.impl;

import com.lpl.dao.IAccountDao;

/**
 * 账户持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    /**
     * 模拟保存账户
     */
    //由于此类交给Bean工厂去创建为单例的，所以最好不要声明可修改的成员变量，否则会造成线程安全问题
    //private int i = 0;
    public void saveAccount() {
        int i = 0;
        System.out.println("持久层保存了账户！");
        i++;
        System.out.println(i);
    }
}
