package com.unbank.mybatis.mapper;

import java.util.List;

import com.unbank.entity.Area;
import com.unbank.mybatis.entity.SqlAdapter;

public interface AreaMapper {

	List<Area> selectAreas(SqlAdapter sqlAdapter);
}
