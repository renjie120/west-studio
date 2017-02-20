package com.jd.kibana;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.jd.kibana.entity.Datasource;
import com.jd.kibana.utils.ConfigSingleton;
import com.jd.kibana.utils.KJdbcUtils;

public class JdbcDataGather {
	
	private  KJdbcUtils jdbcUtils;
	public JdbcDataGather(Datasource ds)
	{
		String password = ds.getPassword();

		if(ds.getDatasourceType().equals("5")) //properties
		{
			ConfigSingleton config = ConfigSingleton.getInstance();
			password = config.getProperties(password);
		}
		jdbcUtils = new KJdbcUtils(ds.getUerName(),password,ds.getDriver(),ds.getUrl());  

	}
	
	public List<Map<String, Object>> getData(String sql)
	{
		jdbcUtils.getConnection();
		List<Map<String, Object>> data = null;
		try {
			data = jdbcUtils.findModeResult(sql, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			jdbcUtils.releaseConn();
		}
		
		return data;
	}
	
	public List<String> getMetaData(String sql)
	{
		jdbcUtils.getConnection();
		List<String> data = null;
		try {
			data = jdbcUtils.findModeMetadata(sql, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			jdbcUtils.releaseConn();
		}
		
		return data;
	}

}
