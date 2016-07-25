package com.unbank.service;

import java.util.List;

import com.unbank.entity.TreeModel;

public interface TreeService {
	public List<TreeModel> readTreeByDbAndPId(String dbcode, String pid);
}
