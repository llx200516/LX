package com.schj.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.schj.entity.Member;
import com.schj.entity.Position;
import com.schj.entity.Record;
import com.schj.entity.Resume;
import com.schj.mapper.PositionMapper;
import com.schj.mapper.RecordMapper;
import com.schj.mapper.ResumeMapper;
import com.schj.service.RecServices;
import com.schj.utils.RetClMessage;
import com.schj.vo.PageRequest;

@Service
public class RecServiceImpl implements RecServices {

	
			@Autowired
			private PositionMapper posmapper;
			
			@Autowired
			private RecordMapper recmapper;
			
			@Autowired
			private ResumeMapper resmapper;
		
			public String seleComidByComName(String Name, String intention,
					Member member) {
				Map<Object, Object>comap=new HashMap<Object, Object>();
				SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Position pos=null;
				try {
					pos=posmapper.selectPosidByComName(Name);
					if(pos!=null){
						//ְλID �ѻ�ȡ
						//У��û�Ա�Ƿ�Ͷ�ݴθ�λ
						boolean flag = checkRec(member.getId(),pos.getId());
						/**
						 * ��ȡ��Ա��Ϣ��У�����ݿ��Ƿ����Ͷ�ݼ�¼��if�У���ô������ʾ��û�У���ȡ�������� ����Ͷ�ݼ�����
						 */
						if(flag){
							// �����Ͷ�ݣ���ô������ʾ��Ϣ
							comap.put("100","���û��Ѷ�ְλͶ�ݹ��������ظ�Ͷ��");
						}else{
							//���ݻ�ԱID����ְ�����ȡ���� Ȼ�����Ͷ�ݡ�
							List<Resume> reslist=resmapper.findResIdByMemidI(member.getId(), intention);
							
							if(reslist.get(0).getId()==0){
								comap.put("101","δ�ҵ��û�Ա�ļ���");
							}else{
								/**
								 * ����ҵ��˼�������ְλ����Ƹ����У�飬�����Ƹ����Ϊ0����ô������Ͷ�ݳɹ���������Ϣ
								 */
								Position posss=posmapper.resultById(pos.getId());
								if(posss.getRecnumber()==0){
									comap.put("999","��ְλ��ֹͣ��Ƹ");
								}else{
									Record cord=new Record();
									cord.setMemid(member.getId());
									cord.setPosid(pos.getId());
									cord.setResid(reslist.get(0).getId());
									cord.setSendtime(simdate.format(new Date()));
									cord.setResult(0);
									int result=recmapper.Icord(cord);
									if(result > 0){
										comap.put("200","Ͷ�ݼ����ɹ�");
									}else{
										comap.put("201","Ͷ�ݼ���ʧ��");
									}
								}
							}
						}
					}else{
						comap.put("101","��ѯְλIDʧ��");
					}
				} catch (Exception e) {
					//log.error(e);
				}
				return comap.toString();
			}
	
			//У���Ƿ����Ͷ��
			public boolean checkRec(int memid,int posid){
				boolean flag=false;
				Record rec=null;
				try {
					rec = recmapper.checkRecByMidPosId(memid, posid);
					if(rec!=null){
						flag = true;
					}else{
						flag=false;
					}
				} catch (Exception e) {
					//log.error(e);
				}
				return flag;
			}

			public String modiRec(Record record) {
				Map<Object, Object>recmap=new HashMap<Object, Object>();
				try {
					int result=recmapper.RecresultModi(record);
					Position pos=posmapper.resultById(record.getPosid());
					//������Խ��Ϊ��ͨ������ôְλ��ŵ���Ƹְλ-1
					if(record.getResult()==2){
						int ress=posmapper.recuMberByid(pos.getRecnumber()-1, record.getPosid());
							if(ress > 0){
								recmap.put("1000", "���Խ�������ɹ�");
							}else{
								recmap.put("1001", "���Խ������ʧ��");
							}
					}else{
						if(result > 0){
							recmap.put("100", "���Խ�������ɹ�");
						}else{
							recmap.put("101", "���Խ������ʧ��");
						}
					}
				} catch (Exception e) {
					//log.error(e);
				}
				return recmap.toString();
			}

			public PageInfo<Record> getPageInfoAll(String posName,
					String comName, PageRequest pageRequest) {
				  	int pageNum = pageRequest.getPageNum();
			        int pageSize = pageRequest.getPageSize();
			        PageHelper.startPage(pageNum, pageSize);
			        List<Record> posMenus = recmapper.seleAllr(posName,comName);
			        return new PageInfo<Record>(posMenus);
			}

			public List<Record> reexcel() {
				return recmapper.reexcel();
			}

			
			

			public String excel(List<Record> list) {
				Map<Object, Object>recmap=new HashMap<Object, Object>();
				FileOutputStream fout=null;
				Workbook wb = new XSSFWorkbook();
				//1.1�����ñ��ĸ�ʽ----����
				CellStyle cs = wb.createCellStyle();
				cs.setAlignment(HorizontalAlignment.CENTER);
				//2.1������������
				Sheet sheet = wb.createSheet("��˾ɸѡͳ��");
						//2.2���ϲ���Ԫ��
						sheet.addMergedRegion(new CellRangeAddress(5, 9, 6, 10));
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
						cell.setCellValue("��Ͷ��");
						cell.setCellStyle(cs);
					cell = row.createCell(3);
						cell.setCellValue("δͨ��");
						cell.setCellStyle(cs);
					cell = row.createCell(4);
						cell.setCellValue("��ͨ��");
						cell.setCellStyle(cs);
				
				//5��д��ʵ������
				for (int i = 0; i < list.size(); i++) {
					//3.2��������----������
					int yms=recmapper.toudisum(list.get(i).getPosition().getPosName(), list.get(i).getPosition().getCompany().getComName());
					int Wtg=recmapper.mianssum(list.get(i).getPosition().getPosName(), list.get(i).getPosition().getCompany().getComName());
					int Ytg=recmapper.tonggsum(list.get(i).getPosition().getPosName(), list.get(i).getPosition().getCompany().getComName());
					row = sheet.createRow(i+1);
						//�ڼ��еڼ���  ��һ�е�һ��Ϊ��code��
					row.createCell(0).setCellValue(list.get(i).getPosition().getCompany().getComName());
					row.createCell(1).setCellValue(list.get(i).getPosition().getPosName());
					if(yms!=0){
						row.createCell(2).setCellValue(yms);
					}else{
						row.createCell(2).setCellValue(0);
					}
					if(Wtg!=0){
						row.createCell(3).setCellValue(Wtg);
					}else{
						row.createCell(3).setCellValue(0);
					}
					if(Ytg!=0){
						row.createCell(4).setCellValue(Ytg);
					}else{
						row.createCell(4).setCellValue(0);
					}
				}
				
				//6�����ļ����浽ָ��λ��
				try {
					fout = new FileOutputStream("C:\\Users\\SXJ\\Desktop\\zjwdb.xlsx");
					recmap.put(RetClMessage.SuccessCode,RetClMessage.ResultSuccess );
					wb.write(fout);
				} catch (IOException e) {
					e.printStackTrace();
					recmap.put(RetClMessage.FailedCode,RetClMessage.ResultFailed);
				}
				finally{
					try {
						fout.close();
					} catch (IOException e) {
					}
				}
				return recmap.toString();	
			
		}

	
}
