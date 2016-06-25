package com.owen.mybatis.mappers;


import java.util.List;

import com.owen.mybatis.domain.Student;
/**
 * �������� Strudent �ӿ�
 * @author OwenWilliam 2016-6-18
 * @since
 * @version v1.0.0
 *
 */
public interface StudentMapper
{
	/**
	 * ����������Student
	 * @return
	 */
	List<Student> findAllStudents();
	/**
	 * ͨ��ID�Ų���Student
	 * @param id
	 * @return
	 */

	Student findStudentById(Integer id);

	/**
	 * �����µ�Student
	 * @param student
	 */
	void insertStudent(Student student);

	/**
	 * ����Student
	 * @param student
	 */
	void updateStudent(Student student);
}