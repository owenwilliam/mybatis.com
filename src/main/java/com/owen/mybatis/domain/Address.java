package com.owen.mybatis.domain;

import java.io.Serializable;

/**
 * 地址信息：Student与其是一对一    Tutor与其是一对一
 * 
 * @author OwenWilliam 2016-6-20
 * @since
 * @version v3.0.0
 *
 */
public class Address implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer addrId;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;

	@Override
	public String toString()
	{
		return "Address [addrId=" + addrId + ", street=" + street + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", country="
				+ country + "]";
	}

	public Address()
	{
	}

	public Address(Integer addrId)
	{
		this.addrId = addrId;
	}

	public Address(Integer addrId, String street, String city, String state,
			String zip, String country)
	{
		this.addrId = addrId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}

	public Integer getAddrId()
	{
		return addrId;
	}

	public void setAddrId(Integer addrId)
	{
		this.addrId = addrId;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

}
