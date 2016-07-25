package com.unbank.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unbank.dao.QgDataDao;
import com.unbank.entity.QgData;
import com.unbank.mybatis.entity.SqlAdapter;
import com.unbank.mybatis.mapper.QgDataMapper;

@Repository
public class QgDataDaoImpl implements QgDataDao {
	@Autowired
	QgDataMapper qgDataMapper;

	@Override
	public List<QgData> readInformations(String dbcode, String pid,
			String address, String time) {
		SqlAdapter sqlAdapter = new SqlAdapter();
		String sql = "select * from " + dbcode + "_data where categoryid='"
				+ pid + "' order by time desc ";
		sqlAdapter.setSql(sql);
		return qgDataMapper.readInfoDataBySQLAdapter(sqlAdapter);
	}

}
