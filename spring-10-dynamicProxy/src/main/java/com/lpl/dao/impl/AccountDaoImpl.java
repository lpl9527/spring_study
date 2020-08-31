package com.lpl.dao.impl;

import com.lpl.bean.Account;
import com.lpl.dao.IAccountDao;
import com.lpl.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository
public class AccountDaoImpl implements IAccountDao {

    //使用dbutils查询
    @Autowired
    private QueryRunner queryRunner;

    /**
     * 注意：此处使用了与线程绑定的Connection对象，而不必将其注入QueryRunner中
     */
    @Autowired
    private ConnectionUtils connectionUtils;

    /**
     * 根据账户名称查询账户
     * @param accountName 账户名称
     * @return  如果有唯一结果就返回账户，没有结果返回null，有多个结果抛异常
     */
    public Account findByName(Integer accountName) {
        try{
            //由于我们表中没有账户名称，使用uid代替
            String sql = "select * from account where uid = ?";
            List<Account> accounts = queryRunner.query(connectionUtils.getThreadConnection(), sql, new BeanListHandler<Account>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0){
                return null;
            }
            if (accounts.size() >1){
                throw new RuntimeException("账户结果集不唯一，数据异常！");
            }
            return accounts.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询所有账户
     */
    public List<Account> findAll() {
        try{
            String sql  = "select * from account";
            List<Account> accounts = queryRunner.query(connectionUtils.getThreadConnection(), sql, new BeanListHandler<Account>(Account.class));
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
            Account account = queryRunner.query(connectionUtils.getThreadConnection(), sql, new BeanHandler<Account>(Account.class), id);
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
            queryRunner.update(connectionUtils.getThreadConnection(), sql, account.getUid(), account.getMoney());
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
            queryRunner.update(connectionUtils.getThreadConnection(), sql, account.getUid(), account.getMoney(),account.getId());
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
            queryRunner.update(connectionUtils.getThreadConnection(), sql, id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
