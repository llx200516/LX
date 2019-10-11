package com.schj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.schj.entity.Company;
import com.schj.mapper.CompanyMapper;
import com.schj.service.ComServices;
import com.schj.utils.PageUtils;
import com.schj.vo.PageRequest;

/***
 * 
 * @author llx
 * @version 1.0 time 2019-10-09 PM 15:10
 * 
 */

@ResponseBody
@RestController
public class ComController {

	// 日志记录。
	static Log log = LogFactory.getLog(ComController.class);

	@Autowired
	private ComServices comServices;

	// 分页查询插件完成分页

	@RequestMapping(value = "/findPageCom", method = RequestMethod.POST)
	Object findPageCom(PageRequest pageRequest) {
		return PageUtils.getPageResult(pageRequest, comServices.getPageInfo(pageRequest));
	}
	
	//维护公司信息
	@RequestMapping(value="/inseComi",method=RequestMethod.POST)
	String inseComI(Company company){
		return comServices.inseComI(company);
	}
	
	//修改公司信息
	@RequestMapping(value="/modiComf",method=RequestMethod.POST)
	String modiComF(Company company){
		return comServices.modiComF(company);
	}
	
	//清除公司信息
	@RequestMapping("/deleComd")
	String deleComD(int id){
		return comServices.deleComD(id);
	}

}
