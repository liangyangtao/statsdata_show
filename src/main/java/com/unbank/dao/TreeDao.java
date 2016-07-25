package com.unbank.dao;

import java.util.List;

import com.unbank.entity.TreeModel;

public interface TreeDao {

	List<TreeModel> readTreeByDbAndPId(String dbcode, String pid);

}
