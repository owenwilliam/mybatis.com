package com.owen.mybatis.domain;

import java.util.Date;

/**
 * 实体类 Student 参数的名字可以不与数据中的一个具体配置在xml中，要相对应就ok了
 * 
 * @author OwenWilliam 2016-6-18
 * @since Entity
 * @version v2.0.0
 *
 */

public class Student
{
	private Integer studId;
	private String name;
	private String email;
	private Date dob;

	public Student()
	{

	}

	public Student(Integer studId)
	{
		this.studId = studId;
	}

	public Student(Integer studId, String name, String email, Date dob)
	{
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	@Override
	public String toString()
	{
		return "Student [studId=" + studId + ", name=" + name + ", email="
				+ email + ", dob=" + dob + "]";
	}

	public Integer getStudId()
	{
		return studId;
	}

	public void setStudId(Integer studId)
	{
		this.studId = studId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

}
