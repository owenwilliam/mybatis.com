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
 * �����ݿ����ӵ�JDBC��
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
			//��ȡ���ݿ�������Ϣ
			InputStream is = DataSourceFactory.class.getResourceAsStream("/application.properties");
			PROPERTIES.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ʹ�õ���ģʽ����
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory()
	{
		if(sqlSessionFactory==null) 
		{
			InputStream inputStream = null;
			try
			{
				//��ȡ�����ļ���Ϣ
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				//����Ϣ�ŵ�������
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
	 * ���ݿ�����
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