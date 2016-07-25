package com.unbank.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unbank.dao.InfoDataDao;
import com.unbank.entity.InfoData;
import com.unbank.mybatis.entity.SqlAdapter;
import com.unbank.mybatis.mapper.InfoDataMapper;

@Repository
public class InfoDataDaoImpl implements InfoDataDao {

	@Autowired
	InfoDataMapper infoDataMapper;

	@Override
	public List<InfoData> readInfoDatas(String dbcode, String code,
			String address) {

		SqlAdapter sqlAdapter = new SqlAdapter();
		String sql =null;
		if(dbcode.startsWith("fs")){
			sql = "select * from " + dbcode + "_data where wdcode='" + code
					+ "' and regcode ='" + address + "'";
		}else if(dbcode.startsWith("hg")){
			sql = "select * from " + dbcode + "_data where wdcode='" + code
					+ "'";
		}
		sqlAdapter.setSql(sql);
		return infoDataMapper.readInfoDataBySQLAdapter(sqlAdapter);
	}

}
