package com.owen.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 Student 参数的名字可以不与数据中的一个具体配置在xml中，要相对应就ok了
 * 
 * @author OwenWilliam 2016-6-18
 * @since Entity
 * @version v2.0.0
 *
 */

public class Student implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer studId;
	private String name;
	private String email;
	private PhoneNumber phone;
	private Address address;

	@Override
	public String toString()
	{
		return "Student [studId=" + studId + ", name=" + name + ", email="
				+ email + ", phone="
				+ (phone == null ? null : phone.getAsString()) + ", address="
				+ address + "]";
	}

	public Student()
	{
	}

	public Student(Integer id)
	{
		this.studId = id;
	}

	public Integer getStudId()
	{
		return studId;
	}

	public void setStudId(Integer id)
	{
		this.studId = id;
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

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public PhoneNumber getPhone()
	{
		return phone;
	}

	public void setPhone(PhoneNumber phone)
	{
		this.phone = phone;
	}
}
