package com.lpl.service.impl;

import com.lpl.bean.Account;
import com.lpl.dao.IAccountDao;
import com.lpl.service.IAccountService;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    /**
     * 提供setter方法用于spring setter注入
     */
    public  void setAccountDao(IAccountDao accountDao){
        this.accountDao = accountDao;
    }

    /**
     * 查询所有账户
     */
    public List<Account> findAll() {

        return accountDao.findAll();
    }

    /**
     * 根据id查询账户
     */
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    /**
     * 保存账户
     */
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    /**
     * 更新账户
     */
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    /**
     * 删除账户
     */
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
