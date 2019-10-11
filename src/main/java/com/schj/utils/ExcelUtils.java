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
			//1.1�����ñ��ĸ�ʽ----����
		CellStyle cs = wb.createCellStyle();
		cs.setAlignment(HorizontalAlignment.CENTER);
		//2.1������������
		Sheet sheet = wb.createSheet("��˾ɸѡͳ��");
				//2.2���ϲ���Ԫ��
				sheet.addMergedRegion(new CellRangeAddress(4, 8, 5, 9));
		//3.1��������----��ͷ��
		Row row = sheet.createRow(0);
		//4��������
		Cell cell = row.createCell(0);
				cell.setCellValue("��˾����");
				cell.setCellStyle(cs);
			cell = row.createCell(1);
				cell.setCellValue("ְλ����");
				cell.setCellStyle(cs);
			cell = row.createCell(2);
				cell.setCellValue("���Խ��");
				cell.setCellStyle(cs);
		
		//5��д��ʵ������
		for (int i = 0; i < list.size(); i++) {
			//3.2��������----������
			row = sheet.createRow(i+1);
				//�ڼ��еڼ���  ��һ�е�һ��Ϊ��code��
			row.createCell(0).setCellValue(list.get(i).getPosition().getCompany().getComName());
			row.createCell(1).setCellValue(list.get(i).getPosition().getPosName());
			row.createCell(2).setCellValue(list.get(i).getResult());
		}
		
		//6�����ļ����浽ָ��λ��
		try {
			FileOutputStream fout = new FileOutputStream("C:\\Users\\SXJ\\Desktop\\llxxxx.xlsx");
			wb.write(fout);
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	
}
	
}
