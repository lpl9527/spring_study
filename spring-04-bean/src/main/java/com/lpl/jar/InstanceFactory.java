package com.lpl.jar;

import com.lpl.service.IAccountService;
import com.lpl.service.impl.AccountServiceImpl;

/**
 * 模仿一个工厂类，该类可能存在于jar包中，无法通过源码的方式来提供构造函数注入，可使用其中的方法创建对象
 */
public class InstanceFactory {

    /**
     * 此方法用于spring获取返回的对象
     * @return
     */
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
