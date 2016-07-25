package com.unbank.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unbank.dao.AreaDao;
import com.unbank.entity.Area;
import com.unbank.mybatis.entity.SqlAdapter;
import com.unbank.mybatis.mapper.AreaMapper;


@Repository
public class AreaDaoImpl implements AreaDao {

	
	@Autowired
	AreaMapper areaMapper;
	
	
	public List<Area> readArea() {
		SqlAdapter sqlAdapter = new SqlAdapter();
		String sql ="select * from area";
		sqlAdapter.setSql(sql );
		return areaMapper.selectAreas(sqlAdapter);
	}

}
