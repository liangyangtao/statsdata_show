package com.unbank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbank.dao.InformationDao;
import com.unbank.entity.Information;
import com.unbank.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService {

	@Autowired
	InformationDao imInformationDao;
	
	@Override
	public List<Information> readInformations(String dbcode, String pid) {
		return imInformationDao.readInformations(dbcode,pid);
	}

}
