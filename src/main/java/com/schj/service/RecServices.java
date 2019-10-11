package com.schj.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.schj.entity.Member;
import com.schj.entity.Record;
import com.schj.vo.PageRequest;

public interface RecServices {
	
	//修改记录表信息
	String modiRec(Record record);
	
	//分页处理方法
	PageInfo<Record> getPageInfoAll(String posName,String comName,PageRequest pageRequest);
	
	//根据公司名称返回公司ID 主要处理投递简历流程
	String seleComidByComName(String Name,String intention,Member member);
	
	//导出excel
	List<Record> reexcel();
	
	String excel(List<Record> list);
	
}
