package com.owen.mybatis.services;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.owen.mybatis.domain.Course;
import com.owen.mybatis.domain.Tutor;

/**
 * 测试Turtor
 * 
 * @author OwenWilliam 2016-6-20
 * @since
 * @version v3.0.0
 *
 */

public class TutorServiceTest
{
	private static TutorService tutorService;

	@BeforeClass
	public static void setup()
	{
		TestDataPopulator.initDatabase();
		tutorService = new TutorService();
	}

	@AfterClass
	public static void teardown()
	{
		tutorService = null;
	}

	@Test
	public void testFindTutorById()
	{
		Tutor tutor = tutorService.findTutorById(1);
		Assert.assertNotNull(tutor);
		List<Course> courses = tutor.getCourses();
		Assert.assertNotNull(courses);
		for (Course course : courses)
		{
			Assert.assertNotNull(course);
			// System.out.println(course);
		}
	}

}
