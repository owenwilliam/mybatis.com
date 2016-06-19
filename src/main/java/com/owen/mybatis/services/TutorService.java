package com.owen.mybatis.services;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.owen.mybatis.domain.Tutor;
import com.owen.mybatis.mappers.TutorMapper;
import com.owen.mybatis.util.MyBatisUtil;

/**
 * Turtor的业务层操作
 * 
 * @author OwenWilliam 2016-6-20
 * @since
 * @version v3.0.0
 *
 */

public class TutorService
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	public Tutor findTutorById(int tutorId)
	{
		logger.debug("findTutorById :" + tutorId);
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try
		{
			TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);
			return mapper.selectTutorById(tutorId);
		}

		finally
		{
			sqlSession.close();
		}
	}

}
