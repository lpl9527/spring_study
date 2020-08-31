package com.lpl.service.impl;

import com.lpl.bean.Account;
import com.lpl.dao.IAccountDao;
import com.lpl.service.IAccountService;
import com.lpl.utils.ConnectionUtils;
import com.lpl.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 * 注意：事务的控制都应该是在业务层的
 */
@Service
public class AccountServiceImpl_old implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Autowired
    private TransactionManager transactionManager;

    //---------------------------------------------------------------------------------------
    /**
     * 转账
     * @param sourceName    转出账户
     * @param targetName    转入账户
     * @param money     转出金额
     */
    public void transfer(Integer sourceName, Integer targetName, Float money) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();

            //2.执行操作
            //2.1根据名称查询转出账户
            Account source = accountDao.findByName(sourceName);
            //2.2根据名称查询转入账户
            Account target = accountDao.findByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5更新转出账户
            accountDao.updateAccount(source);

            //使异常，测试事务
            int i = 1/0;

            //2.6更新转入账户
            accountDao.updateAccount(target);

            //3.提交事务
            transactionManager.commit();
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            transactionManager.release();
        }
    }

    /**
     * 查询所有账户
     */
    public List<Account> findAll() {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAll();
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return accounts;
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            transactionManager.release();
        }
    }

    /**
     * 根据id查询账户
     */
    public Account findById(Integer id) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findById(id);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return account;
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            transactionManager.release();
        }
    }

    /**
     * 保存账户
     */
    public void saveAccount(Account account) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            transactionManager.commit();
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            transactionManager.release();
        }
    }

    /**
     * 更新账户
     */
    public void updateAccount(Account account) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            transactionManager.commit();
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            transactionManager.release();
        }
    }

    /**
     * 删除账户
     */
    public void deleteAccount(Integer id) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(id);
            //3.提交事务
            transactionManager.commit();
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //5.释放连接
            transactionManager.release();
        }
    }
}
