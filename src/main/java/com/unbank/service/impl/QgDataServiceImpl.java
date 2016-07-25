package com.unbank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbank.dao.QgDataDao;
import com.unbank.entity.QgData;
import com.unbank.service.QgDataService;

@Service
public class QgDataServiceImpl implements QgDataService {

	@Autowired
	QgDataDao qgDataDao;

	@Override
	public List<QgData> readInformations(String dbcode, String pid,
			String address, String time) {
		return qgDataDao.readInformations(dbcode, pid, address, time);
	}

}
