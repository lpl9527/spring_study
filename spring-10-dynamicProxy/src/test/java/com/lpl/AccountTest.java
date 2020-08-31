package com.lpl;

import com.lpl.bean.Account;
import com.lpl.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})
public class AccountTest {

    @Autowired
    //@Qualifier("accountService")
    @Qualifier("proxyAccountService")   //注意：此处使用了代理的AccountService
    private IAccountService accountService;

    /**
     * 测试转账方法，此时对事务的控制已经又持久层转到了业务层
     */
    @Test
    public void transferTest(){
        accountService.transfer(45, 46, 100f);
    }
}
