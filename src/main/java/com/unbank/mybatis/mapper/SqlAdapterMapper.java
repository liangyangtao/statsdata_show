package com.unbank.mybatis.mapper;

import com.unbank.mybatis.entity.SqlAdapter;


public interface SqlAdapterMapper {

	void executeSQL(SqlAdapter sqlAdapter);

	void executeMapSQL(SqlAdapter sqlAdapter);

	int insertReturnPriKey(SqlAdapter sqlAdapter);
	

}
