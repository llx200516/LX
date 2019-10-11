package com.schj.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.schj.entity.Record;
import com.schj.service.RecServices;


public class ExcelUtils {
	
	public static void RetExcel(List<Record> list){
		Workbook wb = new XSSFWorkbook();
			//1.1、设置表格的格式----居中
		CellStyle cs = wb.createCellStyle();
		cs.setAlignment(HorizontalAlignment.CENTER);
		//2.1、创建工作表
		Sheet sheet = wb.createSheet("公司筛选统计");
				//2.2、合并单元格
				sheet.addMergedRegion(new CellRangeAddress(4, 8, 5, 9));
		//3.1、创建行----表头行
		Row row = sheet.createRow(0);
		//4、创建格
		Cell cell = row.createCell(0);
				cell.setCellValue("公司名称");
				cell.setCellStyle(cs);
			cell = row.createCell(1);
				cell.setCellValue("职位名称");
				cell.setCellStyle(cs);
			cell = row.createCell(2);
				cell.setCellValue("面试结果");
				cell.setCellStyle(cs);
		
		//5、写入实体数据
		for (int i = 0; i < list.size(); i++) {
			//3.2、创建行----内容行
			row = sheet.createRow(i+1);
				//第几行第几格  第一行第一格为“code”
			row.createCell(0).setCellValue(list.get(i).getPosition().getCompany().getComName());
			row.createCell(1).setCellValue(list.get(i).getPosition().getPosName());
			row.createCell(2).setCellValue(list.get(i).getResult());
		}
		
		//6、将文件储存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("C:\\Users\\SXJ\\Desktop\\llxxxx.xlsx");
			wb.write(fout);
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	
}
	
}
