package com.lpl.service.impl;

import com.lpl.bean.Account;
import com.lpl.dao.IAccountDao;
import com.lpl.service.IAccountService;
import com.lpl.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 * 注意：事务的控制都应该是在业务层的
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    //---------------------------------------------------------------------------------------
    /**
     * 转账
     * @param sourceName    转出账户
     * @param targetName    转入账户
     * @param money     转出金额
     */
    public void transfer(Integer sourceName, Integer targetName, Float money) {

        System.out.println("使用了JDK动态代理技术实现业务层事务操作...");
        //1.根据名称查询转出账户
        Account source = accountDao.findByName(sourceName);
        //2根据名称查询转入账户
        Account target = accountDao.findByName(targetName);
        //3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //5更新转出账户
        accountDao.updateAccount(source);

        //使异常，测试事务
        //int i = 1/0;

        //6更新转入账户
        accountDao.updateAccount(target);

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
