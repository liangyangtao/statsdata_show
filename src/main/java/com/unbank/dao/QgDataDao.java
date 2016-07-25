package com.unbank.dao;

import java.util.List;

import com.unbank.entity.QgData;

public interface QgDataDao {

	List<QgData> readInformations(String dbcode, String pid, String address,
			String time);

}
