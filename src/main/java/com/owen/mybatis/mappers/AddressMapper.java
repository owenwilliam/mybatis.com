package com.owen.mybatis.mappers;

import com.owen.mybatis.domain.Address;

/**
 * 地址的映射接口
 * 
 * @author OwenWilliam 2016-6-20
 * @since
 * @version v3.0.0
 *
 */
public interface AddressMapper
{
	/**
	 * 通过ID号查找所有的地址
	 * 
	 * @param id
	 * @return
	 */
	Address findAddressById(Integer id);
}
