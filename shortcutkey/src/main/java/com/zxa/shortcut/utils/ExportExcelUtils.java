package com.zxa.shortcut.utils;

import com.zxa.shortcut.bean.ExcelData;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @ClassName: ExcelExportUtil
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/12/9 18:52
 */
public class ExportExcelUtils {

	static Logger logger = LoggerFactory.getLogger(ExportExcelUtils.class);

	public static void exportExcel(HttpServletResponse response, String fileName, ExcelData data) throws Exception {
		// 告诉浏览器用什么软件可以打开此文件
		response.setHeader("content-Type", "application/vnd.ms-excel");
		// 下载文件的默认名称
		response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
		exportExcel(data, response.getOutputStream());
	}




	public static void exportExcel(ExcelData data, OutputStream out) throws Exception {
		logger.info("Enter exportExcel" + System.currentTimeMillis());

		SXSSFWorkbook wb = new SXSSFWorkbook();
		try {
			String sheetName = data.getName();
			if (null == sheetName) {
				sheetName = "Sheet1";
			}
			SXSSFSheet sheet = wb.createSheet(sheetName);
			sheet.protectSheet("test");
			writeExcel(wb, sheet, data);

			ByteArrayOutputStream out1 = new ByteArrayOutputStream();

			wb.write(out1);

			ByteArrayInputStream inputStream = new ByteArrayInputStream(out1.toByteArray());


			POIFSFileSystem fs = new POIFSFileSystem();
			EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
//			 EncryptionInfo info = new EncryptionInfo（EncryptionMode.agile，CipherAlgorithm.aes192，HashAlgorithm.sha384，-1，-1，null）;

			Encryptor enc= info.getEncryptor();
			enc.confirmPassword("test");

			try (OPCPackage opc = OPCPackage.open(inputStream);
			     OutputStream os = enc.getDataStream(fs)) {
				opc.save(os);
			}

// Write out the encrypted version

			fs.writeFilesystem(out);

			fs.close();


		} finally {
			wb.close();
		}

		logger.info("Exit exportExcel" + System.currentTimeMillis());
	}

	public static void writeExcel(SXSSFWorkbook wb, SXSSFSheet sheet, ExcelData data) {

		int rowIndex = 0;

		rowIndex = writeTitlesToExcel(wb, sheet, data.getTitles());
		writeRowsToExcel(wb, sheet, data.getRows(), rowIndex);
		autoSizeColumns(sheet, data.getTitles().size() + 1);

	}

	private static int writeTitlesToExcel(SXSSFWorkbook wb, Sheet sheet, List<String> titles) {
		int rowIndex = 0;
		int colIndex = 0;

		XSSFFont titleFont = (XSSFFont) wb.createFont();
		titleFont.setFontName("simsun");
		titleFont.setBold(true);
		 titleFont.setFontHeightInPoints((short) 14);
		titleFont.setColor(IndexedColors.BLACK.index);

		XSSFCellStyle titleStyle = (XSSFCellStyle)wb.createCellStyle();
		titleStyle.setAlignment(HorizontalAlignment.CENTER);
		titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//		titleStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(168,108,142)));
		titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		titleStyle.setFont(titleFont);
		setBorder(titleStyle, BorderStyle.THIN, new XSSFColor());

		org.apache.poi.ss.usermodel.Row titleRow = sheet.createRow(rowIndex);
		 titleRow.setHeightInPoints(25);
		colIndex = 0;

		for (String field : titles) {
			Cell cell = titleRow.createCell(colIndex);
			cell.setCellValue(field);
			cell.setCellStyle(titleStyle);
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

	private static void setBorder(CellStyle style, BorderStyle border, XSSFColor color) {
		style.setBorderTop(border);
		style.setBorderLeft(border);
		style.setBorderRight(border);
		style.setBorderBottom(border);
//		style.setTopBorderColor();
//		style.setBorderColor(XSSFCellBorder.BorderSide.LEFT, color);
//		style.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, color);
//		style.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, color);
	}
}