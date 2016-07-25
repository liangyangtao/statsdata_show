package com.unbank.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unbank.dao.TreeDao;
import com.unbank.entity.TreeModel;
import com.unbank.mybatis.entity.SqlAdapter;
import com.unbank.mybatis.mapper.TreeMapper;

@Repository
public class TreeDaoImpl implements TreeDao {
	@Autowired
	TreeMapper treeMapper;

	@Override
	public List<TreeModel> readTreeByDbAndPId(String dbcode, String pid) {
		if (pid == null) {
			pid = "";
			if (dbcode.startsWith("qg")) {
				pid = "AA";
			}

		}
		SqlAdapter sqlAdapter = new SqlAdapter();
		String sql = "select * from " + dbcode + "_tree where pid='" + pid
				+ "'";
		sqlAdapter.setSql(sql);
		return treeMapper.readTreeBySQLAdapter(sqlAdapter);
	}

}
