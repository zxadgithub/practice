package com.zxa.shortcut.utils;

import com.zxa.shortcut.bean.ExcelData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @ClassName: ExcelExportUtil
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/12/9 18:52
 */
public class ExportExcelUtils1 {

	static Logger logger = LoggerFactory.getLogger(ExportExcelUtils1.class);
	static final int SHARE = 1000;
	public static void exportExcel(HttpServletResponse response, String fileName, ExcelData data) throws Exception {
		// 告诉浏览器用什么软件可以打开此文件
		response.setHeader("content-Type", "application/vnd.ms-excel");
		// 下载文件的默认名称
		response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
		exportExcel(data, response.getOutputStream());
	}

	public static void exportExcel(ExcelData data, OutputStream out) throws Exception {
		logger.info("Enter exportExcel" + System.currentTimeMillis());
		writeExcel(data, out);
		logger.info("Exit exportExcel" + System.currentTimeMillis());
	}

	private static void writeExcel(ExcelData data, OutputStream out) throws Exception  {
		SXSSFWorkbook wb = new SXSSFWorkbook();
		List list = data.getRows();
		SXSSFSheet sheet;
		String sheetName = data.getName();
		try {
			if (null == sheetName) {
				sheetName = "Sheet1";
			}
			sheet = wb.createSheet(sheetName);


			int rowIndex = 0;
			rowIndex = writeTitlesToExcel(wb, sheet,data.getTitles());
			writeRowsToExcel(wb, sheet, data.getRows(), rowIndex);

			wb.write(out);
		} finally {
			wb.close();
		}
		int size = list.size()/SHARE;
		for (int i = 1; i < size; i++) {

			String finalSheetName = sheetName;
			int finalI = i;
			new Runnable(){

				@Override
				public void run() {
					SXSSFWorkbook wb1 = new SXSSFWorkbook();
					try {
						SXSSFSheet sheet1 = wb1.getSheet(finalSheetName);


						int rowIndex = 0;
						rowIndex = writeTitlesToExcel(wb1, sheet1, data.getTitles());
						writeRowsToExcel(wb1, sheet1, list.subList(finalI * SHARE , (finalI + 1) * SHARE), finalI * SHARE);

						wb1.write(out);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							wb1.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			};


		}

	}

	private static int writeTitlesToExcel(SXSSFWorkbook wb, Sheet sheet, List<String> titles) {
		int rowIndex = 0;
		int colIndex = 0;

		XSSFFont titleFont = (XSSFFont) wb.createFont();
		titleFont.setFontName("simsun");
		titleFont.setBold(true);
		// titleFont.setFontHeightInPoints((short) 14);
		titleFont.setColor(IndexedColors.BLACK.index);

//		XSSFCellStyle titleStyle = wb.createCellStyle();
//		titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
//		titleStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
//		titleStyle.setFillForegroundColor(new XSSFColor(new Color(182, 184, 192)));
//		titleStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
//		titleStyle.setFont(titleFont);
//		setBorder(titleStyle, BorderStyle.THIN, new XSSFColor(new Color(0, 0, 0)));

		Row titleRow = sheet.createRow(rowIndex);
		// titleRow.setHeightInPoints(25);
		colIndex = 0;

		for (String field : titles) {
			Cell cell = titleRow.createCell(colIndex);
			cell.setCellValue(field);
//			cell.setCellStyle(titleStyle);
			colIndex++;
		}

		rowIndex++;
		return rowIndex;
	}

	private static int writeRowsToExcel(SXSSFWorkbook wb, SXSSFSheet sheet, List<List<Object>> rows, int rowIndex) {
		logger.info("Enter writeRowsToExcel" + System.currentTimeMillis());
		int colIndex = 0;

		Font dataFont = wb.createFont();
		dataFont.setFontName("simsun");
		// dataFont.setFontHeightInPoints((short) 14);
		dataFont.setColor(IndexedColors.BLACK.index);

//		XSSFCellStyle dataStyle = wb.createCellStyle();
//		dataStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
//		dataStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
//		dataStyle.setFont(dataFont);
//		setBorder(dataStyle, BorderStyle.THIN, new XSSFColor(new Color(0, 0, 0)));

		for (List<Object> rowData : rows) {
			Row dataRow = sheet.createRow(rowIndex);
			// dataRow.setHeightInPoints(25);
			colIndex = 0;

			for (Object cellData : rowData) {
				Cell cell = dataRow.createCell(colIndex);
				if (cellData != null) {
					cell.setCellValue(cellData.toString());
				} else {
					cell.setCellValue("");
				}

//				cell.setCellStyle(dataStyle);
				colIndex++;
			}
			rowIndex++;
		}
		logger.info("Exit writeRowsToExcel" + System.currentTimeMillis());
		return rowIndex;
	}

	private static void autoSizeColumns(SXSSFSheet sheet, int columnNumber) {
		sheet.trackAllColumnsForAutoSizing();
		for (int i = 0; i < columnNumber; i++) {
			int orgWidth = sheet.getColumnWidth(i);
			sheet.autoSizeColumn(i, true);
			int newWidth = (int) (sheet.getColumnWidth(i) + 100);
			if (newWidth > orgWidth) {
				sheet.setColumnWidth(i, newWidth);
			} else {
				sheet.setColumnWidth(i, orgWidth);
			}
		}
	}

	private static void setBorder(XSSFCellStyle style, BorderStyle border, XSSFColor color) {
		style.setBorderTop(border);
		style.setBorderLeft(border);
		style.setBorderRight(border);
		style.setBorderBottom(border);
		style.setBorderColor(XSSFCellBorder.BorderSide.TOP, color);
		style.setBorderColor(XSSFCellBorder.BorderSide.LEFT, color);
		style.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, color);
		style.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, color);
	}
}