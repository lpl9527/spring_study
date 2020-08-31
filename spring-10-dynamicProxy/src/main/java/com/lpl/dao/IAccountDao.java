package com.lpl.dao;

import com.lpl.bean.Account;

import java.util.List;

/**
 * 账户持久层接口
 */
public interface IAccountDao {

    /**
     * 根据账户名称查询账户
     */
    Account findByName(Integer accountName);

    /**
     * 查询所有账户
     */
    List<Account> findAll();
    /**
     * 根据id查询
     */
    Account findById(Integer id);
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
