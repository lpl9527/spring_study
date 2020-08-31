package com.lpl.service;

import com.lpl.bean.Account;
import com.lpl.dao.IAccountDao;

/**
 * 账户业务层接口
 */
public interface IAccountService {

    /**
     * 根据id查询账户信息
     */
    Account findAccountById(Integer id);
    /**
     * 转账
     */
    void transfer(String sourceName, String targetName, Float money);
}
