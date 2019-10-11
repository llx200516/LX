package com.schj.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schj.entity.Resume;
import com.schj.mapper.ResumeMapper;
import com.schj.service.ResServices;

@Service
public class ResServiceImpl implements ResServices {

		
	@Autowired
	private ResumeMapper mapper;
	
	public String inserRes(Resume resume) {
		Map<Object, Object> resmap = new HashMap<Object, Object>();
		try {
			int result=mapper.inserRes(resume);
			if(result > 0)
				resmap.put("100", "ά��������Ϣ�ɹ�");
			else
				resmap.put("101", "ά��������Ϣʧ��");
		} catch (Exception e) {
			// TODO: handle exception ����쳣��Ϣ
		}
		return resmap.toString();
	}

	public String updatRes(Resume resume) {
		Map<Object, Object> resmap = new HashMap<Object, Object>();
		try {
			int result=mapper.updatRes(resume);
			if(result > 0)
				resmap.put("100", "�޸ļ�����Ϣ�ɹ�");
			else
				resmap.put("101", "�޸ļ�����Ϣʧ��");
		} catch (Exception e) {
			// TODO: handle exception ����쳣��Ϣ
		}
		return resmap.toString();
	}

	public String deleRes(Resume resume) {
		Map<Object, Object> resmap = new HashMap<Object, Object>();
		try {
			int result=mapper.deleRes(resume);
			if(result > 0)
				resmap.put("100", "���������Ϣ�ɹ�");
			else
				resmap.put("101", "���������Ϣʧ��");
		} catch (Exception e) {
			// TODO: handle exception ����쳣��Ϣ
		}
		return resmap.toString();
	}

}
