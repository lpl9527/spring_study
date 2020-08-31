package com.lpl.service.impl;

import com.lpl.dao.IAccountDao;
import com.lpl.dao.impl.AccountDaoImpl;
import com.lpl.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl对象创建了！");
    }

    /**
     * 模拟保存账户
     */
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
