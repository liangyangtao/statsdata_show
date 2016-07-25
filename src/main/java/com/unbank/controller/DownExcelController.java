package com.unbank.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unbank.common.CommonController;

@Controller
@RequestMapping(value = "/")
public class DownExcelController extends CommonController {

	@RequestMapping(value = "downExcel")
	public void downExcel(HttpServletResponse response, HttpSession session,
			String table, Model model) {
		if (table.isEmpty()) {
			return;
		} else {
			table = table.replace("&nbsp;", "");
		}
		InputStream in = null;
		OutputStream out = null;
		File file = null;
		try {
			XSSFWorkbook xwb = new XSSFWorkbook();
			makeExcel(xwb, table);
			String result = makeExcelFile(xwb);
			file = new File(result);
			response.setHeader("content-disposition", "attachment;filename="
					+ URLEncoder.encode(file.getName(), "UTF-8"));
			in = new FileInputStream(result); // 获取文件的流
			int len = 0;
			byte buf[] = new byte[1024];// 缓存作用
			out = response.getOutputStream();// 输出流
			while ((len = in.read(buf)) > 0) // 切忌这后面不能加 分号 ”;“
			{
				out.write(buf, 0, len);// 向客户端输出，实际是把数据存放在response中，然后web服务器再去response中读取
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (file != null) {
				file.delete();
			}
		}
	}

	private void makeExcel(XSSFWorkbook xwb, String table) {
		XSSFSheet sheet = xwb.createSheet("info");
		Document document = Jsoup.parse(table);
		Element tableElement = document.select("table").first();
		Elements trElement = tableElement.select("tr");
		XSSFRow row;
		Map<Integer, Set<Integer>> megeinfo = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < trElement.size(); i++) {
			row = sheet.createRow(i);
			Elements tdElements = trElement.get(i).select("td,th");
			int colNum = 0;
			for (int j = 0; j < tdElements.size(); j++) {
				while (megeinfo.get(colNum) != null
						&& megeinfo.get(colNum).contains(i)) {
					colNum++;
				}
				Cell cell = row.createCell(colNum);
				cell.setCellValue(tdElements.get(j).text().trim());
				if (tdElements.get(j).hasAttr("colspan")) {
					int start = colNum;
					String a = tdElements.get(j).attr("colspan");
					int cs = Integer.parseInt(a);
					for (int k = 0; k < cs - 1; k++) {
						colNum++;
						cell = row.createCell(colNum);
					}
					try {
						CellRangeAddress region = new CellRangeAddress(i, i,
								start, colNum);
						sheet.addMergedRegionUnsafe(region);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (tdElements.get(j).hasAttr("rowspan")) {
					int start = i;
					int end = i;
					String a = tdElements.get(j).attr("rowspan");
					int rs = Integer.parseInt(a);
					Set<Integer> aa = null;
					if (megeinfo.get(colNum) != null) {
						aa = megeinfo.get(colNum);
					} else {
						aa = new HashSet<Integer>();
					}
					aa.add(start);
					for (int k = 0; k < rs - 1; k++) {
						aa.add(++end);
					}
					megeinfo.put(colNum, aa);
					try {
						CellRangeAddress region = new CellRangeAddress(start,
								end, colNum, colNum);
						sheet.addMergedRegion(region);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				colNum++;
			}
		}

	}

	private String makeExcelFile(XSSFWorkbook xwb) {
		StringBuffer fileName = new StringBuffer();
		fileName.append(new Date().getTime() + ".xlsx");
		String path = null;
		try {
			path = DownExcelController.class.getClassLoader().getResource("")
					.toURI().getPath();
			path = path.substring(1, path.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String filePath = path + "temp/";
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		filePath = filePath + fileName.toString();
		try {
			FileOutputStream fileOut = new FileOutputStream(filePath);
			xwb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;

	}
}
