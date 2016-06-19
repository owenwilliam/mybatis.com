package com.owen.mybatis.mappers;

import java.util.List;
import java.util.Map;

import com.owen.mybatis.domain.Course;

/**
 * 课程的映射
 * 
 * @author OwenWilliam 2016-6-20
 * @since
 * @version v3.0.0
 *
 */
public interface CourseMapper
{

	/**
	 * 通过turor查找课程
	 * 
	 * @param tutorId
	 * @return
	 */
	List<Course> selectCoursesByTutor(int tutorId);

	/**
	 * 通过多个值查找课程
	 * 
	 * @param map
	 * @return
	 */
	List<Course> searchCourses(Map<String, Object> map);

	/**
	 * 通过多个值查找Turtor
	 * 
	 * @param map
	 * @return
	 */
	List<Course> searchCoursesByTutors(Map<String, Object> map);

}
