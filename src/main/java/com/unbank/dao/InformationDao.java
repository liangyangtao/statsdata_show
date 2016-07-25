package com.unbank.dao;

import java.util.List;

import com.unbank.entity.Information;

public interface InformationDao {

	List<Information> readInformations(String dbcode, String pid);

}
