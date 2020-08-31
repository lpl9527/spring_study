package com.lpl.dao.impl;

import com.lpl.bean.Account;
import com.lpl.dao.IAccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    //使用dbutils查询
    @Autowired
    private QueryRunner queryRunner;

    /**
     * 查询所有账户
     */
    public List<Account> findAll() {
        try{
            String sql  = "select * from account";
            List<Account> accounts = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));
            return accounts;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据id查询账户
     */
    public Account findById(Integer id) {
        try{
            String sql  = "select * from account where id = ?";
            Account account = queryRunner.query(sql, new BeanHandler<Account>(Account.class), id);
            return account;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 保存账户
     */
    public void saveAccount(Account account) {
        try{
            String sql  = "insert into account(uid, money) values(?, ?)";
            queryRunner.update(sql, account.getUid(), account.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新账户
     */
    public void updateAccount(Account account) {
        try{
            String sql  = "update account set uid=?, money=? where id=?";
            queryRunner.update(sql, account.getUid(), account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除账户
     */
    public void deleteAccount(Integer id) {
        try{
            String sql = "delete from account where id=?";
            queryRunner.update(sql, id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
