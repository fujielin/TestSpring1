package com.yc.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @program: testSpring
 * @description:
 * @author: Bauer
 * @create: 2021-04-15 18:59
 */
@Configuration
@ComponentScan(basePackages = {"com.yc"})
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        DataSource ds = new ComboPooledDataSource();//直接用ds调用不到子类特有的方法
        ((ComboPooledDataSource) ds).setDriverClass("com.mysql.jdbc.Driver");//强制转换
        ((ComboPooledDataSource) ds).setJdbcUrl("jdbc:mysql://localhost:3306/testbank?serverTimezone=GMT%2B8");
        ((ComboPooledDataSource) ds).setUser("root");
        ((ComboPooledDataSource) ds).setPassword("root");

        return ds;
    }

    @Bean
    public TransactionManager DataSourceTransactionManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}
