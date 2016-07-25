package com.unbank.service;

import java.util.List;

import com.unbank.entity.InfoData;

public interface InfoDataService {

	List<InfoData> readInfoDatas(String dbcode,String code, String address);

}
