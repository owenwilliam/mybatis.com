package com.owen.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/*
 import javax.sql.DataSource;
 import org.apache.ibatis.datasource.pooled.PooledDataSource;
 import org.apache.ibatis.session.SqlSessionFactory;
 import org.mybatis.spring.SqlSessionFactoryBean;
 import org.springframework.context.annotation.Bean;
 */
/**
 * 
 * @author OwenWilliam 2016-6-26
 * @since
 * @version v5.0.0
 *
 */
@Configuration
@MapperScan(value = "com.owen.mybatis.mappers")
public class AppConfig
{
	/*
	 * @Bean public DataSource dataSource() { return new
	 * PooledDataSource("com.mysql.jdbc.Driver",
	 * "jdbc:mysql://localhost:3306/elearning", "root", "admin"); }
	 * 
	 * @Bean public SqlSessionFactory sqlSessionFactory() throws Exception {
	 * SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	 * sessionFactory.setDataSource(dataSource()); return
	 * sessionFactory.getObject(); }
	 */
}
