package com.schj.service;

import com.github.pagehelper.PageInfo;
import com.schj.entity.Company;
import com.schj.vo.PageRequest;

public interface ComServices {
	
	//�����˾��Ϣ
	String deleComD(int id);
	
	//�޸Ĺ�˾��Ϣ
	String modiComF(Company company);
	
	//ά����˾��Ϣ
	String inseComI(Company company);
	
	//��ҳ�������
	PageInfo<Company> getPageInfo(PageRequest pageRequest);
}
