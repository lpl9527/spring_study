package com.lpl.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbctemplate的最基本用法
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {

        //创建数据源，使用spring内置数据源DriverManagerDataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_study?useUnicode=true&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("Gepoint");

        //1.创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //2.执行操作
        jdbcTemplate.execute("insert into account(name, money) values('斑斑', 2000.0)");
    }
}
