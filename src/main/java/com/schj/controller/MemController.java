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
		//���ڷ���ǰ̨��Ϣ��
		return memservice.inetMem(member);
	}
	
	
	//�޸Ļ�Ա��Ϣ
	@RequestMapping(value="/updatMem",method=RequestMethod.POST)
	public String updatMem(Member member){
		return memservice.updatMem(member);
	}
	
	//�����Ա��Ϣ
	@RequestMapping(value="/deleMem",method=RequestMethod.POST)
	public String deleMem(Member member){
		return memservice.deleMem(member);
	}
}
