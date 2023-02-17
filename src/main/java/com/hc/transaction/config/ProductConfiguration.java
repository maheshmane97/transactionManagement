package com.hc.transaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class ProductConfiguration {
    //@EnableAspectJAutoProxy proxy will create. client request now not go directly to the service it goes via proxy :: client->proxy->service
    @Bean
    public DataSource dataSource(){
        return  new DriverManagerDataSource("jdbc:mysql://localhost:3306/transaction",
                "root",
                "root");
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){

        return new JdbcTemplate(dataSource());
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
