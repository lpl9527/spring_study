package com.lpl.service.impl;

import com.lpl.dao.IAccountDao;
import com.lpl.factory.BeanFactory;
import com.lpl.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    //private IAccountDao accountDao = new AccountDaoImpl();
    //降低耦合，使用Bean工厂读取配置文件创建Bean对象
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    /**
     * 模拟保存账户
     */
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
