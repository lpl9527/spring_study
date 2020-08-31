package com.lpl.jar;

import com.lpl.service.IAccountService;
import com.lpl.service.impl.AccountServiceImpl;

/**
 * 一个类，该类可能存在于jar包中，无法通过源码的方式来提供构造函数注入，可使用其中的静态方法创建对象
 */
public class StaticFactory {

    /**
     * 此方法用于spring获取返回的对象
     * @return
     */
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
