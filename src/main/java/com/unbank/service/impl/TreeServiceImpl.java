package com.unbank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbank.dao.TreeDao;
import com.unbank.entity.TreeModel;
import com.unbank.service.TreeService;

@Service
public class TreeServiceImpl implements TreeService {

	@Autowired
	TreeDao treeDao;

	@Override
	public List<TreeModel> readTreeByDbAndPId(String dbcode, String pid) {
		return treeDao.readTreeByDbAndPId(dbcode,pid);
	}

}
