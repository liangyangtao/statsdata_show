package com.unbank.mybatis.mapper;

import java.util.List;

import com.unbank.entity.TreeModel;
import com.unbank.mybatis.entity.SqlAdapter;

public interface TreeMapper {

   public	List<TreeModel> readTreeBySQLAdapter(SqlAdapter sqlAdapter);
   
}
