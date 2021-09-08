package com.atguigu.spring5.Config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Classname Config
 * @Description TODO
 * @Date 20:21 2021/3/31
 * @Created by hejx
 *
 * 使用配置类（实际：基于注解方式下的操作）
 */
@Configuration //使得产生的多个DataSource Bean是同一个
@ComponentScan(basePackages = {"com.atguigu.spring5"})
@EnableTransactionManagement   //开启事务
public class TxConfig {
    //数据库连接池
    @Bean
    public DruidDataSource getdruidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/spring5_day05");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("1234");
        return druidDataSource;
    }

    //创建Jdbc模板对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        //到ioc容器中根据类型找到dataSource
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //注入dataSource
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    //创建事务管理器
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
