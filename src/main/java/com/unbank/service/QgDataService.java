package com.unbank.service;

import java.util.List;

import com.unbank.entity.QgData;

public interface QgDataService {

	public List<QgData> readInformations(String dbcode, String pid,
			String address, String time);

}
