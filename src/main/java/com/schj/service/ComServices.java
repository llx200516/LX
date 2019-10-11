package com.schj.service;

import com.github.pagehelper.PageInfo;
import com.schj.entity.Company;
import com.schj.vo.PageRequest;

public interface ComServices {
	
	//清除公司信息
	String deleComD(int id);
	
	//修改公司信息
	String modiComF(Company company);
	
	//维护公司信息
	String inseComI(Company company);
	
	//分页插件代码
	PageInfo<Company> getPageInfo(PageRequest pageRequest);
}
