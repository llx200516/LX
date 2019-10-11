package com.schj.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.schj.entity.Company;
import com.schj.mapper.CompanyMapper;
import com.schj.service.ComServices;
import com.schj.vo.PageRequest;

@Service
public class ComServiceImpl implements ComServices {
	
	
	@Autowired 
	private CompanyMapper companyMapper;
	
	public String deleComD(int id) {
		Map<String, String>comap=new HashMap<String, String>();
		try {
			int result=companyMapper.delComD(id);
			if(result > 0)
				comap.put("100", "成功清除公司信息");
			else
				comap.put("101", "清除公司信息异常");
		} catch (Exception e) {
		}
		return comap.toString();
	}
	
	//对维护信息上游字段校验
		boolean checkCom(Company company){
			boolean flag=false;
			if(company.getComName()!=null&&!"".equals(company.getComName())&&company.getComAddress()!=null&&!"".equals(company.getComAddress())
					&&company.getInvolved()!=null&&!"".equals(company.getInvolved())){
				flag = true;
			}
			return flag;
		}

	public String modiComF(Company company) {
		Map<String, String>comap=new HashMap<String, String>();
		if(company !=null){
			boolean flag=checkCom(company);
			if(flag){
				int result = companyMapper.modiComM(company);
				if(result > 0){
					comap.put("000", "修改公司信息成功");
				}else{
					comap.put("001", "修改公司数据失败");
				}
			}else{
				comap.put("002", "数据校验失败");
			}
		}else{
			comap.put("003", "上游数据为空");
		}
		return comap.toString();
	}

	public String inseComI(Company company) {
		Map<String, String>comap=new HashMap<String, String>();
		if(company !=null){
			boolean flag=checkCom(company);
			if(flag){
				int result = companyMapper.inserComI(company);
				if(result > 0){
					comap.put("000", "维护公司信息成功");
				}else{
					comap.put("001", "维护公司数据失败");
				}
			}else{
				comap.put("002", "数据校验失败");
			}
		}else{
			comap.put("003", "上游数据为空");
		}
		return comap.toString();
	}

	public PageInfo<Company> getPageInfo(PageRequest pageRequest) {
		int pageNum = pageRequest.getPageNum();
		int pageSize = pageRequest.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		List<Company> posMenus = companyMapper.selePageCom();
		return new PageInfo<Company>(posMenus);
	}
	
}
