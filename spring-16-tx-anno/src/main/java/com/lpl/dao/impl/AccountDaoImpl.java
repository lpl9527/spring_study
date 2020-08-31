package com.lpl.dao.impl;

import com.lpl.bean.Account;
import com.lpl.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据id查询账户
     */
    public Account findAccountById(Integer id) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    /**
     * 根据名称查询账户
     */
    public Account findAccountByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()){
            return null;
        }
        if (accounts.size() > 1){
            throw new RuntimeException("根据名称查询账户结果集不唯一！");
        }
        return accounts.get(0);
    }

    /**
     * 更新账户
     */
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name=?, money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }
}
