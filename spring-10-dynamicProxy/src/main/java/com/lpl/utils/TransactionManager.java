package com.lpl.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 事务管理相关工具类
 */
@Component
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try{
            //关闭自动提交
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    public void commit(){
        try{
            //提交事务
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    public void rollback(){
        try{
            //回滚事务
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 释放资源
     */
    public void release(){
        try{
            //释放连接，将连接还回池中
            connectionUtils.getThreadConnection().close();
            //将连接和线程解绑
            connectionUtils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
