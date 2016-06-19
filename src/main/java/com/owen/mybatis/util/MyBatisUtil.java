package com.owen.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;

import com.owen.mybatis.domain.Student;
import com.owen.mybatis.mappers.StudentMapper;
import com.owen.mybatis.typehandlers.PhoneTypeHandler;

/**
 * 
 * @author OwenWilliam 2016-6-19
 * @since
 * @version v2.0.0
 *
 */

public class MyBatisUtil
{
	private static SqlSessionFactory xmlSqlSessionFactory;
	private static SqlSessionFactory javaSqlSessionFactory;

	/**
	 * 读取XNL的文件配置
	 * 
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactoryUsingXML()
	{
		if (xmlSqlSessionFactory == null)
		{
			InputStream inputStream;
			try
			{
				inputStream = Resources
						.getResourceAsStream("mybatis-config.xml");
				xmlSqlSessionFactory = new SqlSessionFactoryBuilder()
						.build(inputStream);
			} catch (IOException e)
			{
				throw new RuntimeException(e);
			}
		}
		return xmlSqlSessionFactory;
	}

	/**
	 * 使用JavaAPI的设置
	 * 
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactoryUsingJavaAPI()
	{
		if (javaSqlSessionFactory == null)
		{
			try
			{
				DataSource dataSource = DataSourceFactory.getDataSource();
				// 使用JDBC的形式--用于Tomcat，也可以用ManagedTransactionFactory()--用于JBOSS、webLog
				// and so on
				TransactionFactory transactionFactory = new JdbcTransactionFactory();
				// 你是使用哪一套数据库
				Environment environment = new Environment("development",
						transactionFactory, dataSource);
				Configuration configuration = new Configuration(environment);
				// 注册别名
				configuration.getTypeAliasRegistry().registerAlias("student",
						Student.class);
				// 注册Handler
				configuration.getTypeHandlerRegistry().register(
						PhoneTypeHandler.class);
				// 添加Mapper有对象
				configuration.addMapper(StudentMapper.class);
				javaSqlSessionFactory = new SqlSessionFactoryBuilder()
						.build(configuration);

			} catch (Exception e)
			{
				throw new RuntimeException(e);
			}
		}
		return javaSqlSessionFactory;
	}

}
