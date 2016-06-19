package com.owen.mybatis.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.owen.mybatis.domain.Student;
import com.owen.mybatis.mappers.StudentMapper;

/**
 * Student的业务 层操作,具体操作
 * 
 * @author OwenWilliam 2016-6-19
 * @since
 * @version v2.0.0
 *
 */
public class StudentService
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	private SqlSessionFactory factory;

	public StudentService(SqlSessionFactory factory)
	{
		this.factory = factory;
	}

	protected SqlSession openSqlSession()
	{
		return factory.openSession();
	}

	/**
	 * 查找所有的Student
	 * 
	 * @return
	 */
	public List<Student> findAllStudents()
	{
		SqlSession sqlSession = openSqlSession();
		try
		{
			// 获得Student的映射
			StudentMapper studentMapper = sqlSession
					.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		} finally
		{
			sqlSession.close();
		}
	}

	/**
	 * 通过ID号查找Student
	 * 
	 * @param studId
	 * @return
	 */
	public Student findStudentById(Integer studId)
	{
		logger.debug("Select Student By ID :{}", studId);
		SqlSession sqlSession = openSqlSession();
		try
		{
			StudentMapper studentMapper = sqlSession
					.getMapper(StudentMapper.class);
			return studentMapper.findStudentById(studId);
		} finally
		{
			sqlSession.close();
		}
	}

	/**
	 * 创建Student
	 * 
	 * @param student
	 */
	public void createStudent(Student student)
	{
		SqlSession sqlSession = openSqlSession();
		try
		{
			StudentMapper studentMapper = sqlSession
					.getMapper(StudentMapper.class);
			studentMapper.insertStudent(student);
			sqlSession.commit();
		} finally
		{
			sqlSession.close();
		}
	}

	/**
	 * 更新Student
	 * 
	 * @param student
	 */
	public void updateStudent(Student student)
	{
		SqlSession sqlSession = openSqlSession();
		try
		{
			StudentMapper studentMapper = sqlSession
					.getMapper(StudentMapper.class);
			studentMapper.updateStudent(student);
			sqlSession.commit();
		} finally
		{
			sqlSession.close();
		}
	}
}
