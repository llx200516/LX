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
						//职位ID 已获取
						//校验该会员是否投递次岗位
						boolean flag = checkRec(member.getId(),pos.getId());
						/**
						 * 获取会员信息，校验数据库是否存在投递记录，if有，那么返回提示，没有，获取完整数据 进行投递简历。
						 */
						if(flag){
							// 如果已投递，那么返回提示信息
							comap.put("100","该用户已对职位投递过，请勿重复投递");
						}else{
							//根据会员ID和求职意向获取简历 然后进行投递。
							List<Resume> reslist=resmapper.findResIdByMemidI(member.getId(), intention);
							
							if(reslist.get(0).getId()==0){
								comap.put("101","未找到该会员的简历");
							}else{
								/**
								 * 如果找到了简历，对职位的招聘人数校验，如果招聘人数为0，那么将不会投递成功，返回信息
								 */
								Position posss=posmapper.resultById(pos.getId());
								if(posss.getRecnumber()==0){
									comap.put("999","该职位已停止招聘");
								}else{
									Record cord=new Record();
									cord.setMemid(member.getId());
									cord.setPosid(pos.getId());
									cord.setResid(reslist.get(0).getId());
									cord.setSendtime(simdate.format(new Date()));
									cord.setResult(0);
									int result=recmapper.Icord(cord);
									if(result > 0){
										comap.put("200","投递简历成功");
									}else{
										comap.put("201","投递简历失败");
									}
								}
							}
						}
					}else{
						comap.put("101","查询职位ID失败");
					}
				} catch (Exception e) {
					//log.error(e);
				}
				return comap.toString();
			}
	
			//校验是否简历投递
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
					//如果面试结果为已通过，那么职位编号的招聘职位-1
					if(record.getResult()==2){
						int ress=posmapper.recuMberByid(pos.getRecnumber()-1, record.getPosid());
							if(ress > 0){
								recmap.put("1000", "面试结果审批成功");
							}else{
								recmap.put("1001", "面试结果审批失败");
							}
					}else{
						if(result > 0){
							recmap.put("100", "面试结果审批成功");
						}else{
							recmap.put("101", "面试结果审批失败");
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
				//1.1、设置表格的格式----居中
				CellStyle cs = wb.createCellStyle();
				cs.setAlignment(HorizontalAlignment.CENTER);
				//2.1、创建工作表
				Sheet sheet = wb.createSheet("公司筛选统计");
						//2.2、合并单元格
						sheet.addMergedRegion(new CellRangeAddress(5, 9, 6, 10));
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
						cell.setCellValue("已投递");
						cell.setCellStyle(cs);
					cell = row.createCell(3);
						cell.setCellValue("未通过");
						cell.setCellStyle(cs);
					cell = row.createCell(4);
						cell.setCellValue("已通过");
						cell.setCellStyle(cs);
				
				//5、写入实体数据
				for (int i = 0; i < list.size(); i++) {
					//3.2、创建行----内容行
					int yms=recmapper.toudisum(list.get(i).getPosition().getPosName(), list.get(i).getPosition().getCompany().getComName());
					int Wtg=recmapper.mianssum(list.get(i).getPosition().getPosName(), list.get(i).getPosition().getCompany().getComName());
					int Ytg=recmapper.tonggsum(list.get(i).getPosition().getPosName(), list.get(i).getPosition().getCompany().getComName());
					row = sheet.createRow(i+1);
						//第几行第几格  第一行第一格为“code”
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
				
				//6、将文件储存到指定位置
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
