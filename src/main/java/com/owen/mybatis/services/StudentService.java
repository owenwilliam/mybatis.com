package com.owen.mybatis.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.owen.mybatis.domain.Student;
import com.owen.mybatis.mappers.StudentMapper;
import com.owen.mybatis.util.MyBatisSqlSessionFactory;

/**
 * Student��ҵ�� �����
 * @author OwenWilliam 2016-6-18
 * @since
 * @version v1.0.0
 *
 */
public class StudentService
{
private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * �������е�Student
	 * @return
	 */
	public List<Student> findAllStudents()
	{
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			//���Student��ӳ��
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * ͨ��ID�Ų���Student
	 * @param studId
	 * @return
	 */
	public Student findStudentById(Integer studId)
	{
		logger.debug("Select Student By ID :{}", studId);
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentById(studId);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * ����Student
	 * @param student
	 */
	public void createStudent(Student student)
	{
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.insertStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * ����Student
	 * @param student
	 */
	public void updateStudent(Student student)
	{
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.updateStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}