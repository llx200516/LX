package com.schj.service;


import com.schj.entity.Resume;

public interface ResServices {
	
	//���¼�����Ϣ
	String updatRes(Resume resume);
	
	//ά��������Ϣ
	String inserRes(Resume resume);
	
	//���������Ϣ
	String deleRes(Resume resume);
}
