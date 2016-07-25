package com.unbank.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unbank.dao.InformationDao;
import com.unbank.entity.Information;
import com.unbank.mybatis.entity.SqlAdapter;
import com.unbank.mybatis.mapper.InformationMapper;

@Repository
public class InformationDaoImpl implements InformationDao {

	@Autowired
	InformationMapper informationMapper;

	@Override
	public List<Information> readInformations(String dbcode, String pid) {
		
		SqlAdapter sqlAdapter = new SqlAdapter();
		String sql = null;
		sql = "select * from " + dbcode + "_wd where linkPid='" + pid
				+ "' order by sortcode ";
		sqlAdapter.setSql(sql);
		return informationMapper.readInformationBySQLAdapter(sqlAdapter);
	}

}
