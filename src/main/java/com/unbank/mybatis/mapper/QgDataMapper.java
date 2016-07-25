package com.unbank.mybatis.mapper;

import java.util.List;

import com.unbank.entity.QgData;
import com.unbank.mybatis.entity.SqlAdapter;

public interface QgDataMapper {
	List<QgData> readInfoDataBySQLAdapter(SqlAdapter sqlAdapter);
}
