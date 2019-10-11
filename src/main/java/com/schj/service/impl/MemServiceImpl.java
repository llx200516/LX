package com.schj.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schj.entity.Member;
import com.schj.mapper.MemberMapper;
import com.schj.service.MemServices;

@Service
public class MemServiceImpl implements MemServices {
	
	
	@Autowired
	private MemberMapper mapper;
	
	
	//ά����Ա��Ϣ
	public String inetMem(Member member) {
		Map<Object, Object>memap=new HashMap<Object, Object>();
		try {
			int result=mapper.MemInset(member);
			if(result > 0)
				memap.put("100", "ά����Ա��Ϣ�ɹ�");
			else
				memap.put("101", "ά����Ա��Ϣʧ��");
		} catch (Exception e) {
			//����쳣
		}
		return memap.toString();
	}

	//�޸Ļ�Ա��Ϣ
	public String updatMem(Member member) {
		Map<Object, Object>memap=new HashMap<Object, Object>();
		try {
			int result=mapper.MemModi(member);
			if(result > 0)
				memap.put("100", "�޸Ļ�Ա��Ϣ�ɹ�");
			else
				memap.put("101", "�޸Ļ�Ա��Ϣ�ɹ�");
		} catch (Exception e) {
			//����쳣
		}
		return memap.toString();
	}

	//�����Ա��Ϣ
	public String deleMem(Member member) {
		Map<Object, Object>memap=new HashMap<Object, Object>();
		try {
			int result=mapper.MemDelet(member);
			if(result > 0)
				memap.put("100", "�����Ա��Ϣ�ɹ�");
			else
				memap.put("101", "�����Ա��Ϣ�ɹ�");
		} catch (Exception e) {
			//����쳣
		}
		return memap.toString();
	}

}
