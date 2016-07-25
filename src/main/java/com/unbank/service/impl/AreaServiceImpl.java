package com.unbank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbank.dao.AreaDao;
import com.unbank.entity.Area;
import com.unbank.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaDao areaDao;
	
	public List<Area> readArea() {
		return areaDao.readArea();
	}

}
