package com.schj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.schj.entity.Member;
import com.schj.mapper.MemberMapper;
import com.schj.service.MemServices;


@ResponseBody
@RestController
public class MemController {
		
	
	@Autowired
	private MemServices memservice;
	
	@RequestMapping(value="/inetMem",method=RequestMethod.POST)
	public String inetMem(Member member){
		//用于返回前台信息。
		return memservice.inetMem(member);
	}
	
	
	//修改会员信息
	@RequestMapping(value="/updatMem",method=RequestMethod.POST)
	public String updatMem(Member member){
		return memservice.updatMem(member);
	}
	
	//清除会员信息
	@RequestMapping(value="/deleMem",method=RequestMethod.POST)
	public String deleMem(Member member){
		return memservice.deleMem(member);
	}
}
