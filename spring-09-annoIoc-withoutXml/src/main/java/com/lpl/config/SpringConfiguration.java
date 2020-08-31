package com.lpl.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 自定义Spring配置文件，作用和bean.xml配置文件作用相同，一般配置一些通用的配置
 * 注解：
 *      @Configuration：
 *          作用：指定当前类是一个配置类
 *      @ComponentScan：
 *          作用：用于通过注解指定Spring在创建容器时要扫描的包
 *      @Import：
 *          作用：用于导入其他的配置类，有Import注解的类都是父配置类，导入的都是子配置类。
 */
@Configuration
@ComponentScan(basePackages = {"com.lpl"})
@Import(JdbcConfig.class)
public class SpringConfiguration {

}
