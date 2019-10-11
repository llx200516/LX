package com.schj.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.schj.entity.Member;
import com.schj.entity.Record;
import com.schj.vo.PageRequest;

public interface RecServices {
	
	//�޸ļ�¼����Ϣ
	String modiRec(Record record);
	
	//��ҳ������
	PageInfo<Record> getPageInfoAll(String posName,String comName,PageRequest pageRequest);
	
	//���ݹ�˾���Ʒ��ع�˾ID ��Ҫ����Ͷ�ݼ�������
	String seleComidByComName(String Name,String intention,Member member);
	
	//����excel
	List<Record> reexcel();
	
	String excel(List<Record> list);
	
}
