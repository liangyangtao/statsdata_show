package com.unbank.mybatis.mapper;

import java.util.List;

import com.unbank.entity.InfoData;
import com.unbank.mybatis.entity.SqlAdapter;

public interface InfoDataMapper {
	List<InfoData> readInfoDataBySQLAdapter(SqlAdapter sqlAdapter);
}
