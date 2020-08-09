package com.zxa.shortcut.controller;

import com.zxa.shortcut.bean.ExcelData;
import com.zxa.shortcut.utils.ExportExcelUtils;
import com.zxa.shortcut.utils.ExportExcelUtils1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DownLoadController
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/12/9 17:21
 */
@RestController
@Component
public class DownLoadController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	static  List<List<Object>> lists = new ArrayList<>(10000);

	static {
		for (int i = 0; i < 1000; i++) {
			List<Object> objects = new ArrayList<>(2);
			objects.add("name" + i);
			objects.add("operationagsddgadgdfhhhhhhhhhshhsdhdfs" + i);
			objects.add("operation" + i);
			objects.add("operation" + i);
			objects.add("operation" + i);
			lists.add(objects);
		}
	}

	@GetMapping("/download")
	public void download(HttpServletResponse response){

		long start = System.currentTimeMillis();
		logger.info("Enter download" + start);

		ExcelData excelData = new ExcelData();
		excelData.setName("test");
		excelData.setRows(lists);
		List<String> titles = new ArrayList(){{
			add("name");
			add("operation");
			add("operation");
			add("operation");
			add("operation");
		}};
		excelData.setTitles(titles);
		try {
			logger.info("export xml" + System.currentTimeMillis());
			ExportExcelUtils.exportExcel(response,"rest.xlsx",excelData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		logger.info("Exit download" + (end - start));
	}
	@GetMapping("/download1")
	public void download1(HttpServletResponse response){

		long start = System.currentTimeMillis();
		logger.info("Enter download1" + start);

		ExcelData excelData = new ExcelData();
		excelData.setName("test");
		excelData.setRows(lists);
		List<String> titles = new ArrayList(){{
			add("name");
			add("operation");
			add("operation");
			add("operation");
			add("operation");
		}};
		excelData.setTitles(titles);
		try {
			logger.info("export xml" + System.currentTimeMillis());
			ExportExcelUtils1.exportExcel(response,"rest.xlsx",excelData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		logger.info("Exit download1" + (end - start));
	}

}
