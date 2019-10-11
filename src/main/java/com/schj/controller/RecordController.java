package com.schj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
import com.schj.utils.ExcelUtils;
import com.schj.utils.PageUtils;
import com.schj.vo.PageRequest;



@ResponseBody
@RestController
public class RecordController {
	// 日志记录。
		static Log log = LogFactory.getLog(RecordController.class);
		
		@Autowired
		private RecServices recservices;
		
		
		
		//简历投递记录
		@RequestMapping(value="/seleComidBcNe",method=RequestMethod.POST)
		public String seleComidByComName(String Name,String intention,Member member){
			return recservices.seleComidByComName(Name, intention, member);
		}
		
		
		
		//实现面试结果修改
		//参数校验省略，前端校验参数
		//涉及多张表的数据修改 进行事务回滚,未实现
		@Transactional(rollbackFor = Exception.class)
		@RequestMapping(value="/modiRecres",method=RequestMethod.POST)
		public String modiRec(Record record){
			return recservices.modiRec(record);
		}
		
		
		@RequestMapping(value="/findAllre",method=RequestMethod.POST)
		public Object findAllrecume(String posName,String comName,PageRequest pageRequest){
			return PageUtils.getPageResult(pageRequest,recservices.getPageInfoAll(posName,comName,pageRequest));
		}
		
		@RequestMapping(value="/Reexcel",method=RequestMethod.POST)
		public String  reexcel(){
			 List<Record> list=recservices.reexcel();
			String res= recservices.excel(list);
			return res;
		}
		
}
