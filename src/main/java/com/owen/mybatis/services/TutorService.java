package com.owen.mybatis.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
@Transactional
public class TutorService
{

	@Autowired
	private SqlSession sqlSession;

	private TutorMapper getTutorMapper()
	{
		return sqlSession.getMapper(TutorMapper.class);
	}

	public List<Tutor> findAllTutors()
	{
		return getTutorMapper().findAllTutors();
	}

	public Tutor findTutorById(int tutorId)
	{
		return getTutorMapper().findTutorById(tutorId);
	}

	public Tutor findTutorByNameAndEmail(String name, String email)
	{
		return getTutorMapper().findTutorByNameAndEmail(name, email);
	}

	public Tutor createTutor(Tutor tutor)
	{
		getTutorMapper().insertTutor(tutor);
		return tutor;
	}

	public Tutor updateTutor(Tutor tutor)
	{
		getTutorMapper().updateTutor(tutor);
		return tutor;
	}

	public boolean deleteTutor(int tutorId)
	{
		boolean deleted = false;
		int nor = getTutorMapper().deleteTutor(tutorId);
		deleted = (nor == 1);
		return deleted;
	}

	public Tutor selectTutorById(int tutorId)
	{
		return getTutorMapper().selectTutorById(tutorId);
	}

	public Tutor selectTutorWithCoursesById(int tutorId)
	{
		return getTutorMapper().selectTutorWithCoursesById(tutorId);
	}

}
