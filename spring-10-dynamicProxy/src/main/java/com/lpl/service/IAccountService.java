package com.lpl.service;

import com.lpl.bean.Account;

import java.util.List;

public interface IAccountService {


    /**
     * 转账方法
     */
    void transfer(Integer sourceName, Integer targetName, Float money);

    /**
     * 查询所有账户
     */
    List<Account> findAll();
    /**
     * 根据id查询
     */
    Account findById(Integer Id);
    /**
     * 保存
     */
    void saveAccount(Account account);
    /**
     * 更新
     */
    void updateAccount(Account account);
    /**
     * 删除
     */
     void deleteAccount(Integer id);
}
