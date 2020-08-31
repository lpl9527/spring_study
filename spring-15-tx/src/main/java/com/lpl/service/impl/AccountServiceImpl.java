package com.lpl.service.impl;

import com.lpl.bean.Account;
import com.lpl.dao.IAccountDao;
import com.lpl.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 根据id查询账户
     */
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    /**
     * 转账
     */
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        //1.根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //3.转出账户减钱
        source.setMoney(source.getMoney()-money);
        //4.转入账户加钱
        target.setMoney(target.getMoney()+money);
        //5.更新转出账户
        accountDao.updateAccount(source);

        //int i=1/0;

        //6.更新转入账户
        accountDao.updateAccount(target);

    }
}
