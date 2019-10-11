package com.schj.service;


import com.schj.entity.Resume;

public interface ResServices {
	
	//更新简历信息
	String updatRes(Resume resume);
	
	//维护简历信息
	String inserRes(Resume resume);
	
	//清除简历信息
	String deleRes(Resume resume);
}
