package com.unbank.mybatis.mapper;

import java.util.List;

import com.unbank.entity.Information;
import com.unbank.mybatis.entity.SqlAdapter;

public interface InformationMapper {
	List<Information> readInformationBySQLAdapter(SqlAdapter sqlAdapter);
}
