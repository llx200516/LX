package com.schj.controller;

import java.util.HashMap;
import java.util.List;


import java.util.Map;




import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.schj.entity.Position;
import com.schj.mapper.PositionMapper;
import com.schj.service.PosServices;
import com.schj.utils.PageUtils;
import com.schj.vo.PageRequest;

/**
 * 
 * @author llx
 * @version 1.0
 * 日期时间  2019-10-09
 * 
 */
@ResponseBody
@RestController
public class PosController {
	
	static Log log = LogFactory.getLog(PosController.class); 
	
	
	@Autowired
	private PosServices posservice;
	
	@RequestMapping(value="/posAll",method=RequestMethod.GET)
	public List<Position> selectByAll(){
		return posservice.selectByAll();
	}
	
	
	@RequestMapping(value="/posWh",method=RequestMethod.POST)
	public List<Position>selectByWh(@RequestParam String posName,@RequestParam String Education,@RequestParam String comBusiness){
		return posservice.selectByWh(posName, Education, comBusiness);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/posinsert",method=RequestMethod.POST)
	public String insertpos(Position position){
		return posservice.insertpos(position);
	}
	
	@RequestMapping(value="/posdele",method=RequestMethod.POST)
	public String delePos(String posid){
		return posservice.delePos(posid);
	}
	
	
	//分页查询职位表信息
	@RequestMapping(value="/selePage",method=RequestMethod.POST)
	public Object findPagePos(PageRequest pageRequest){
		return PageUtils.getPageResult(pageRequest, posservice.getPageInfo(pageRequest));
	}
	
	
	//分页联合查询
	@RequestMapping(value="/pagePosCom",method=RequestMethod.POST)
	public Object pagePosCom(PageRequest pageRequest,Position position,String comName){
		return PageUtils.getPageResult(pageRequest, posservice.getposCom(pageRequest,position,comName));
	}
	
	
	 
	 
	 @ResponseBody
	 @RequestMapping(value="/updatPos",method=RequestMethod.POST)
	 public String updatPos(Position position){
		 return posservice.updatPos(position);
	 }
	
}
