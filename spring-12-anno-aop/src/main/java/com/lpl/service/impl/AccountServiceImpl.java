package com.lpl.service.impl;

import com.lpl.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    /**
     * 保存账户
     */
    public void saveAccount() {
        System.out.println("执行了保存账户操作！");
    }
    /**
     * 更新账户
     */
    public void updateAccount(int i) {
        System.out.println("执行了更新账户操作！");
    }
    /**
     * 删除账户
     */
    public int deleteAccount() {
        System.out.println("执行了删除账户操作！");
        return 0;
    }

}
