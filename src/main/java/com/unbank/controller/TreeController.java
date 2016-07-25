package com.unbank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unbank.common.CommonController;
import com.unbank.entity.TreeModel;
import com.unbank.service.TreeService;

@Controller
@RequestMapping(value = "/")
public class TreeController extends CommonController {

	@Autowired
	TreeService treeService;

	@RequestMapping(value = "readtree")
	public String readQuotas(HttpServletResponse response, HttpSession session,
			String dbcode, String pid, Model model) {
		List<TreeModel> trees = treeService.readTreeByDbAndPId(dbcode, pid);
		try {
			responseJson(response, trees);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
