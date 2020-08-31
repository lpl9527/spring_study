package com.lpl;

import com.lpl.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 账户测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AcountTest {

    @Autowired
    private IAccountService accountService;

    /**
     * 测试转账
     */
    @Test
    public void transferTest(){
        accountService.transfer("aaa", "bbb", 100f);
    }
}
