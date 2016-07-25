package com.unbank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unbank.common.CommonController;
import com.unbank.entity.InfoData;
import com.unbank.entity.Information;
import com.unbank.entity.QgData;
import com.unbank.service.InfoDataService;
import com.unbank.service.InformationService;
import com.unbank.service.QgDataService;

@Controller
@RequestMapping(value = "/")
public class DetailController extends CommonController {
	private static Logger LOGGER = Logger.getLogger(DetailController.class);

	@Autowired
	InformationService informationService;
	@Autowired
	InfoDataService infoDataService;

	@Autowired
	QgDataService qgDataService;

	@RequestMapping(value = "readInformations")
	public String readInformations(HttpServletResponse response,
			HttpSession session, String dbcode, String pid, String address,
			String time) {
		try {
			responseJson(response, createTable(dbcode, pid, address, time));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String createTable(String dbcode, String pid, String address,
			String time) {
		String table = null;
		if (dbcode.startsWith("qg")) {
			table = qgtable(dbcode, pid, address, time);
		} else {
			table = fshgtable(dbcode, pid, address);
		}
		return table;
	}

	private String qgtable(String dbcode, String pid, String address,
			String time) {
		List<QgData> qgDatas = qgDataService.readInformations(dbcode, pid,
				address, time);
		QgData qgData = qgDatas.get(0);
		String temp = qgData.getText().replace("\\n", "");
		time = qgData.getTime();
		temp = temp.replace("\\", "");
		String timetable = "<div class='time'>" + time + "</div>";
		String table = timetable + "<table class='red'>" + temp + "</table>";
		return table;
	}

	private String fshgtable(String dbcode, String pid, String address) {
		StringBuffer tableBuff = new StringBuffer();
		tableBuff.append("<table border=\"1\">");
		tableBuff.append("<tr>");
		tableBuff.append("<th>");
		tableBuff.append("</th>");
		List<Information> informations = informationService.readInformations(
				dbcode, pid);
		ArrayList<String> times = new ArrayList<String>();
		ArrayList<String> names = new ArrayList<String>();
		LinkedHashMap<String, List<InfoData>> infos = new LinkedHashMap<String, List<InfoData>>();

		for (int i = 0; i < informations.size(); i++) {
			Information information = informations.get(i);
			String code = information.getCode();
			List<InfoData> infoDatas = infoDataService.readInfoDatas(dbcode,
					code, address);
			String name = information.getName();
			names.add(name);
			infos.put(name, infoDatas);
			for (int j = 0; j < infoDatas.size(); j++) {
				InfoData infoData = infoDatas.get(j);
				String time = infoData.getSjcode();
				if (times.contains(time)) {

				} else {
					times.add(time);
				}
			}
		}
		Collections.sort(times);
		Collections.reverse(times);
		for (int i = 0; i < times.size(); i++) {
			tableBuff.append("<th>");
			tableBuff.append(times.get(i));
			tableBuff.append("</th>");
		}
		tableBuff.append("</tr>");

		for (int i = 0; i < names.size(); i++) {
			tableBuff.append("<tr>");
			tableBuff.append("<td>");
			tableBuff.append(names.get(i));
			tableBuff.append("</td>");
			List<InfoData> infoDatas = infos.get(names.get(i));
			for (int j = 0; j < times.size(); j++) {
				String time = times.get(j);
				boolean isHaveData = false;
				for (InfoData infoData : infoDatas) {
					if (infoData.getSjcode().equals(time)) {
						tableBuff.append("<td>");
						tableBuff.append(infoData.getStrdata());
						tableBuff.append("</td>");
						isHaveData = true;
						break;
					}
				}
				if (!isHaveData) {
					tableBuff.append("<td>");
					tableBuff.append("</td>");
				}

			}
			tableBuff.append("</tr>");
		}
		tableBuff.append("</table>");
		return tableBuff.toString();
	}
}
