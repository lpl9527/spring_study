package com.lpl.service.impl;

import com.lpl.bean.Account;
import com.lpl.dao.IAccountDao;
import com.lpl.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)  //只读型事务的配置
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    /**
     * 根据id查询账户
     */
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    /**
     * 转账
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)    //读写星事务配置
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

        int i=1/0;

        //6.更新转入账户
        accountDao.updateAccount(target);

    }
}
