package com.lpl.dao.impl;

import com.lpl.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户持久层实现类
 */
@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {

    /**
     * 模拟保存账户
     */
    public void saveAccount() {
        System.out.println("持久层保存了账户！");
    }
}
