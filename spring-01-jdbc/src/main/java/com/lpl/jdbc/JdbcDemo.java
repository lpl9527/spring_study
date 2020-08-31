package com.lpl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的耦合
 *      耦合： 程序间的依赖关系
 *          包括：
 *              类之间的依赖（IOC降低）
 *              方法之间的依赖（AOP降低）
 *      解耦：降低程序间的依赖关系
 *  实际开发中应该做到：编译器不依赖，运行时才依赖
 *  解耦的思路：
 *      第一步：使用反射创建对象，避免使用new关键字
 *      第二步：通过读取配置文件获取要反射创建的对象的全限定性类名
 */
public class JdbcDemo {

    public static void main(String[] args) throws Exception{
        //1.注册驱动
        //这种做法产生了编译器依赖
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //这种注册驱动方式是运行时依赖
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/mybatis_study?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "Gepoint";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3.操作数据库的预处理对象
        String sql = "select * from account ";
        PreparedStatement ps = conn.prepareStatement(sql);
        //4.执行sql，得到结果集
        ResultSet rs = ps.executeQuery();
        //5.遍历封装结果集
        while (rs.next()){
            System.out.println("每个账户的信息是：---------------------");
            System.out.println(rs.getInt(1));
            System.out.println(rs.getInt(2));
            System.out.println(rs.getFloat(3));
        }
        //6.释放资源
        rs.close();
        ps.close();
        conn.close();

    }
}
