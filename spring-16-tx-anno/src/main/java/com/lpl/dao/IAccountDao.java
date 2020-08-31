package com.lpl.dao;

import com.lpl.bean.Account;

/**
 * 账户持久层接口
 */
public interface IAccountDao {

    /**
     * 根据id查询账户
     */
    Account findAccountById(Integer id);

    /**
     * 根据名称查询账户
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     */
    void updateAccount(Account account);
}
