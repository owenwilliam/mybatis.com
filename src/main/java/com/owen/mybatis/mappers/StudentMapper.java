package com.owen.mybatis.mappers;


import java.util.List;

import com.owen.mybatis.domain.Student;
/**
 * 服务层操作 Strudent 接口
 * @author OwenWilliam 2016-6-18
 * @since
 * @version v1.0.0
 *
 */
public interface StudentMapper
{
	/**
	 * 查找所有有Student
	 * @return
	 */
	List<Student> findAllStudents();
	/**
	 * 通过ID号查找Student
	 * @param id
	 * @return
	 */

	Student findStudentById(Integer id);

	/**
	 * 插入新的Student
	 * @param student
	 */
	void insertStudent(Student student);

	/**
	 * 更新Student
	 * @param student
	 */
	void updateStudent(Student student);
}
