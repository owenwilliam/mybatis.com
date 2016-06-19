package com.owen.mybatis.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.owen.mybatis.domain.Course;
import com.owen.mybatis.mappers.CourseMapper;
import com.owen.mybatis.util.MyBatisUtil;

/**
 * Cource业务操作
 * 
 * @author OwenWilliam 2016-6-20
 * @since
 * @version v3.0.0
 *
 */

public class CourseService
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	public List<Course> searchCourses(Map<String, Object> map)
	{
		logger.debug("searchCourses By :" + map);
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try
		{
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			return mapper.searchCourses(map);
		}

		finally
		{
			sqlSession.close();
		}
	}

	public List<Course> searchCoursesByTutors(Map<String, Object> map)
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try
		{
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			return mapper.searchCoursesByTutors(map);
		}

		finally
		{
			sqlSession.close();
		}
	}
}
