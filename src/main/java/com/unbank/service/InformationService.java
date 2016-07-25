package com.unbank.service;

import java.util.List;

import com.unbank.entity.Information;

public interface InformationService {

	List<Information> readInformations(String dbcode, String pid);

}
