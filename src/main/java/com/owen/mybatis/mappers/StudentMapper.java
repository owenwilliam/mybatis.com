package com.owen.mybatis.mappers;

import java.util.List;
import java.util.Map;

import com.owen.mybatis.domain.Student;

/**
 * 服务层操作 Strudent 接口 与StudentMapper.xml中SQL的id要对应上 查找所：StudentResult
 * 查找个体：Student 参数也要对应xml中的id
 * 
 * @author OwenWilliam 2016-6-18
 * @since
 * @version v1.0.0
 *
 */
public interface StudentMapper
{
	/**
	 * 查找所有有Student
	 * 
	 * @return
	 */
	List<Student> findAllStudents();

	/**
	 * 通过ID号查找Student
	 * 
	 * @param id
	 * @return
	 */

	Student findStudentById(Integer id);

	/**
	 * 查找学生带有地址
	 * 
	 * @param id
	 * @return
	 */
	Student selectStudentWithAddress(int id);

	/**
	 * 插入新的Student
	 * 
	 * @param student
	 */
	void insertStudent(Student student);

	/**
	 * 插入学生
	 * 
	 * @param map
	 */
	void insertStudentWithMap(Map<String, Object> map);

	/**
	 * 更新Student
	 * 
	 * @param student
	 */
	void updateStudent(Student student);

	/**
	 * 删除学生
	 * 
	 * @param id
	 * @return
	 */
	int deleteStudent(int id);
}
