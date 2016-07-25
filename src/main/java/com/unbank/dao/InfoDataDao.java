package com.unbank.dao;

import java.util.List;

import com.unbank.entity.InfoData;

public interface InfoDataDao {

	List<InfoData> readInfoDatas(String dbcode,String code, String address);

	 
}
