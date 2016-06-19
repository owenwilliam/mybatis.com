package com.owen.mybatis.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.owen.mybatis.domain.PhoneNumber;

/**
 * 如果Phone用于user的参数，那mybatis就不能操作setPhone()的属性;
 * 所以需要我们去继承BaseTypeHandler，写个Handler有类， 然后注册到xml的<typeHandlers/>的属性中。
 * 
 * @author OwenWilliam 2016-6-19
 * @since
 * @version v2.0.0
 *
 */

public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber>
{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			PhoneNumber parameter, JdbcType jdbcType) throws SQLException
	{
		ps.setString(i, parameter.getAsString());
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName)
			throws SQLException
	{
		return new PhoneNumber(rs.getString(columnName));
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException
	{
		return new PhoneNumber(rs.getString(columnIndex));
	}

	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException
	{
		return new PhoneNumber(cs.getString(columnIndex));
	}

}
