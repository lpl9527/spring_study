package com.lpl.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * 关于数据库的配置类
 *      @Bean：
 *          作用：用于把当前方法的返回值作为Bean对象放入Spring的IOC容器中。
 *          属性：
 *              name：用于指定Bean的id，不写时默认使用方法名称作为Bean的id。
 *              细节：当使用注解方式配置时，如果方法有参数，spring会去容器中查找有没有可用的Bean对象，
 *                  查找的方式和@Autowired注解一样。
 *      @PropertySource：
 *          作用：用于指定Spring读取properties配置文件的位置。
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    /**
     * 通过配置创建Dbutils的QueryRunner对象
     */
    @Bean("queryRunner")
    @Scope("prototype")
    public QueryRunner getQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 通过配置创建数据源
     */
    @Bean("dataSource")
    public DataSource getDataSource(){
        try{
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
