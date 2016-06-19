/**
 * 
 */
package com.owen.mybatis.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

/**
 * 连接数据库
 * 
 * @author OwenWilliam 2016-6-19
 * @since
 * @version v2.0.0
 *
 */
public class DataSourceFactory
{
	private static final Properties PROPERTIES = new Properties();

	static
	{
		try
		{
			InputStream is = DataSourceFactory.class
					.getResourceAsStream("/application.properties");
			PROPERTIES.load(is);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * dataSource的type属性是POOLED或UNPOOLED
	 * 
	 * @return
	 */
	public static DataSource getDataSource()
	{
		String driver = PROPERTIES.getProperty("jdbc.driverClassName");
		String url = PROPERTIES.getProperty("jdbc.url");
		String username = PROPERTIES.getProperty("jdbc.username");
		String password = PROPERTIES.getProperty("jdbc.password");
		PooledDataSource dataSource = new PooledDataSource(driver, url,
				username, password);
		return dataSource;
	}

	/**
	 * dataSource的type属性是JNDI
	 * 
	 * @return
	 */
	public static DataSource getJNDIDataSource()
	{
		String dataSourceJNDIName = "java:comp/env/jdbc/MyBatisDemoDS";
		try
		{
			InitialContext ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup(dataSourceJNDIName);
			return dataSource;
		} catch (NamingException e)
		{
			throw new RuntimeException(e);
		}
	}
}
