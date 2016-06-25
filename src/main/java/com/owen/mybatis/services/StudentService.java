package com.owen.mybatis.services;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.owen.mybatis.domain.Address;
import com.owen.mybatis.domain.Student;
import com.owen.mybatis.mappers.AddressMapper;
import com.owen.mybatis.mappers.StudentMapper;

/**
 * Student的业务 层操作,具体操作
 * 
 * @author OwenWilliam 2016-6-19
 * @since
 * @version v2.0.0
 *
 */
@Service
@Transactional
public class StudentService
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private AddressMapper addressMapper;

	public List<Student> findAllStudents()
	{
		return studentMapper.findAllStudents();
	}

	public Student findStudentById(Integer id)
	{
		logger.debug("findStudentById :" + id);
		return studentMapper.findStudentById(id);
	}

	public Student findStudentWithAddressById(int id)
	{
		return studentMapper.selectStudentWithAddress(id);
	}

	public Student createStudent(Student student)
	{
		Address address = student.getAddress();
		if (address != null)
		{
			addressMapper.insertAddress(address);
		}
		if (student.getName() == null || student.getName().trim().length() == 0)
		{
			throw new RuntimeException("Student Name should not be null");
		}
		studentMapper.insertStudent(student);
		return student;
	}

	public void createStudentWithMap(Map<String, Object> studentDataMap)
	{
		studentMapper.insertStudentWithMap(studentDataMap);
	}

	public Student updateStudent(Student student)
	{
		studentMapper.updateStudent(student);
		return student;
	}

	public boolean deleteStudent(int id)
	{
		int count = studentMapper.deleteStudent(id);
		return count > 0;
	}

	public Map<String, Object> findStudentMapById(int id)
	{
		return studentMapper.findStudentMapById(id);
	}

	public List<Map<String, Object>> findAllStudentsMap()
	{
		return studentMapper.findAllStudentsMap();
	}
}
