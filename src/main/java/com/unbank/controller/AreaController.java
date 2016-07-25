package com.unbank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unbank.common.CommonController;
import com.unbank.entity.Area;
import com.unbank.service.AreaService;

@Controller
@RequestMapping(value = "/")
public class AreaController extends CommonController {
	private static Logger LOGGER = Logger.getLogger(AreaController.class);
	
	@Autowired
	AreaService areaService;
	
	@RequestMapping(value = "readArea")
	public String readArea(HttpServletResponse response, HttpSession session) {
		List<Area> areas =	areaService.readArea();
		try {
			responseJson(response, areas);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
