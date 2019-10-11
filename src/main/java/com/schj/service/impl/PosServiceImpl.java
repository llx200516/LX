package com.schj.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.schj.entity.Position;
import com.schj.mapper.PositionMapper;
import com.schj.service.PosServices;
import com.schj.vo.PageRequest;

@Service
public class PosServiceImpl implements PosServices {
		
	
	@Autowired
	private PositionMapper posmapper;

	public List<Position> selectByAll() {
		return posmapper.selectByAllPos();
	}

	public List<Position> selectByWh(String posName, String Education,
			String comBusiness) {
		if(posName.equals("")||posName==null){
			posName = null;
		}
		if(Education.equals("")||Education==null){
			Education = null;
		}
		if(comBusiness.equals("")||comBusiness==null){
			comBusiness = null;
		}
		List<Position> pos = null;
		try {
			pos = posmapper.selectByWh(posName,Education,comBusiness);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}
	//对参数进行校验
		public boolean checkpos(Position pos){
			boolean flag=false;
			if(pos.getPosName()!=null&&!"".equals(pos.getPosName())&&pos.getSalary()!=null&&!"".equals(pos.getSalary())
					&&pos.getEducation()!=null&&!"".equals(pos.getEducation())){
				//log.info("参数校验未通过。");
				flag = true;
			}
			return flag;
		}

	public String insertpos(Position position) {
		Map<String, String> map=new HashMap<String, String>();
		
		//校验上游数据
		if(position == null){
			//log.info("上游传入javaBean为空");
		}else{
			try {
				boolean flag=checkpos(position);
				if(flag){
					int result=posmapper.insertPos(position);
					if(result > 0){
						map.put("200", "成功维护一条职位信息");
					}else{
						map.put("101", "异常错误");
					}
				}else{
					map.put("09", "参数校验未通过");
				}
			} catch (Exception e) {
				//log.error(e);
			}
		}
		return map.toString();
	}

	public String delePos(String posid) {
		Map<String, String> map=new HashMap<String, String>();
		try {
			
			int result=posmapper.delectPos(Integer.parseInt(posid));
			if(result > 0){
				map.put("100", "清除了一条职位表信息。");
			}else{
				map.put("102", "清除信息失败。");
			}
		} catch (Exception e) {
			//log.error(e);
		}
		return map.toString();
	}

	public PageInfo<Position> getPageInfo(PageRequest pageRequest) {
		 int pageNum = pageRequest.getPageNum();
	        int pageSize = pageRequest.getPageSize();
	        PageHelper.startPage(pageNum, pageSize);
	        List<Position> posMenus = posmapper.selectPosPage();
	        return new PageInfo<Position>(posMenus);
	}

	public PageInfo<Position> getposCom(PageRequest pageRequest,
			Position position, String comName) {
		 int pageNum = pageRequest.getPageNum();
	        int pageSize = pageRequest.getPageSize();
	        PageHelper.startPage(pageNum, pageSize);
	        if("".equals(position.getPosName())){
	        	position.setPosName(null);
	        }
	        if("".equals(position.getEducation())){
	        	position.setEducation(null);
	        }
	        if("".equals(position.getSalary())){
	        	position.setSalary(null);
	        }
	        if("".equals(comName)){
	        	comName=null;
	        }
	        List<Position> posMenus = posmapper.posComLh(position,comName);
	        return new PageInfo<Position>(posMenus);
	}

	public String updatPos(Position position) {
		Map<String, String> map=new HashMap<String, String>();
		 //对参数进行校验
		 boolean flag=checkpos(position);
		 if(flag){
				 try {
					 int result=posmapper.updatPos(position);
					 if(result > 0){
						 map.put("000", "信息修改完成");
					 }else{
						 map.put("001", "信息修改失败");
					 }
				} catch (Exception e) {
					map.put("002", "进行信息修改时发生了错误！");
				}
		 }else{
			 map.put("007", "参数校验失败");
		 }
		 return map.toString();
	}
}
