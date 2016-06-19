package com.owen.mybatis.mappers;

import com.owen.mybatis.domain.Tutor;

/**
 * 教师的映射
 * 
 * @author OwenWilliam 2016-6-20
 * @since
 * @version v3.0.0
 *
 */
public interface TutorMapper
{

	/**
	 * 查找教师带有课程
	 * 
	 * @param tutorId
	 * @return
	 */
	Tutor selectTutorWithCourses(int tutorId);

	/**
	 * 通过ID查找Turtor
	 * 
	 * @param tutorId
	 * @return
	 */
	Tutor selectTutorById(int tutorId);

}
