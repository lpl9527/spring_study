package com.lpl.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接工具类，用于从数据源中获取一个连接，并实现连接和线程的绑定，从而实现业务层事务的控制
 */
@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    /**
     * 提供setter方法，用于注入
     */
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    /**
     * 获取当前线程上的连接
     */
    public Connection getThreadConnection() {
        try {
            //1.先从ThreadLocal上获取
            Connection conn = threadLocal.get();
            //2.判断当前线程上是否有连接
            if (conn == null) {
                //3.从数据源中获取一个连接并且和当前线程绑定
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            }
            //4.返回当前线程上的连接
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 将连接从线程中移除
     */
    public void removeConnection(){
        threadLocal.remove();
    }

}
