package com.schj.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.schj.entity.Position;
import com.schj.vo.PageRequest;

public interface PosServices {
		
	//查询all职位
	List<Position> selectByAll();
	
	//按条件查询职位，分页
	List<Position>selectByWh(@RequestParam String posName,@RequestParam String Education,@RequestParam String comBusiness);
	
	//维护职位信息
	String insertpos(Position position);
	
	//清除职位信息
	String delePos(String posid);
	
	//修改职位信息
	String updatPos(Position position);
	
	//查询所有职位分页方法
	PageInfo<Position> getPageInfo(PageRequest pageRequest);
	
	
	//条件查询职位分页方法
	PageInfo<Position> getposCom(PageRequest pageRequest,Position position,String comName);
}
