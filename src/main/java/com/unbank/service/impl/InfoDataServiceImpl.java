package com.unbank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbank.dao.InfoDataDao;
import com.unbank.entity.InfoData;
import com.unbank.service.InfoDataService;
@Service
public class InfoDataServiceImpl implements InfoDataService {

	@Autowired
	InfoDataDao infoDataDao;
	
	@Override
	public List<InfoData> readInfoDatas(String dbcode,String code, String address) {
		return infoDataDao.readInfoDatas(dbcode,code,address);
	}

}
