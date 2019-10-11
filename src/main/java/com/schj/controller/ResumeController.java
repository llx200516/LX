package com.schj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.schj.entity.Resume;
import com.schj.mapper.ResumeMapper;
import com.schj.service.ResServices;



@ResponseBody
@RestController
public class ResumeController {

	
	@Autowired
	private ResServices resservices;
	
	@RequestMapping(value="/inserRes",method=RequestMethod.POST)
	public String inserRes(Resume resume){
		return resservices.inserRes(resume);
	}
	
	@RequestMapping(value="/updatRes",method=RequestMethod.POST)
	public String updatRes(Resume resume){
		return resservices.updatRes(resume);
	}
	
	@RequestMapping(value="/deleRes",method=RequestMethod.POST)
	public String deleRes(Resume resume){
		return resservices.deleRes(resume);
	}
}
