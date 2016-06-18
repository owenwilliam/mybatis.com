package com.owen.mybatis.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 与数据库连接的JDBC层
 * @author OwenWilliam 2016-6-18
 * @since
 * @version v1.0.0
 *
 */
public class MyBatisSqlSessionFactory
{
    private static SqlSessionFactory sqlSessionFactory;
	
	private static final Properties PROPERTIES = new Properties();
	
	static
	{
		try {
			//获取数据库连接信息
			InputStream is = DataSourceFactory.class.getResourceAsStream("/application.properties");
			PROPERTIES.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用单例模式操作
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory()
	{
		if(sqlSessionFactory==null) 
		{
			InputStream inputStream = null;
			try
			{
				//获取配置文件信息
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				//将信息放到容器中
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}catch (IOException e)
			{
				throw new RuntimeException(e.getCause());
			}finally {
				if(inputStream != null){
					try {
						inputStream.close();
					} catch (IOException e) {
					}
				}
			}
		}
		return sqlSessionFactory;
	}
	
	public static SqlSession getSqlSession() 
	{
		return getSqlSessionFactory().openSession();
	}
	
	/**
	 * 数据库连接
	 * @return
	 */
	public static Connection getConnection() 
	{
		String driver = PROPERTIES.getProperty("jdbc.driverClassName");
		String url = PROPERTIES.getProperty("jdbc.url");
		String username = PROPERTIES.getProperty("jdbc.username");
		String password = PROPERTIES.getProperty("jdbc.password");
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		return connection;
	}
}
