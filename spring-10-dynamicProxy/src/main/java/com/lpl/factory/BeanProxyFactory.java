package com.lpl.factory;

import com.lpl.service.IAccountService;
import com.lpl.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
@Component
public class BeanProxyFactory {

    @Autowired
    @Qualifier("accountService")
    private IAccountService accountService;

    /**
     * 由于此处匿名内部类要访问成员要求成员变量必须是final类型的，则不能使用注解注入，只能通过setter注入，返回final
     * @param accountService
     */
    /*public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }*/

    @Autowired
    private TransactionManager transactionManager;

    /**
     * 获取Service的代理对象
     */
    public IAccountService getAccountProxyService(){
        //这里使用JDK基于接口的动态代理方式获取
        IAccountService proxyAccountService = (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 对被代理Service添加事务的支持
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        try{
                            //1.开启事务
                            transactionManager.beginTransaction();
                            //2.执行操作
                            result = method.invoke(accountService, args);
                            //3.提交事务
                            transactionManager.commit();
                            //4.返回结果
                            return result;
                        }catch (Exception e){
                            //5.回滚事务
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            //5.释放连接
                            transactionManager.release();
                        }
                    }

                });
        //返回代理对象
        return proxyAccountService;
    }
}
