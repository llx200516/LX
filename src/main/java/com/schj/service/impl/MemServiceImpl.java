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
	
	
	//维护会员信息
	public String inetMem(Member member) {
		Map<Object, Object>memap=new HashMap<Object, Object>();
		try {
			int result=mapper.MemInset(member);
			if(result > 0)
				memap.put("100", "维护会员信息成功");
			else
				memap.put("101", "维护会员信息失败");
		} catch (Exception e) {
			//输出异常
		}
		return memap.toString();
	}

	//修改会员信息
	public String updatMem(Member member) {
		Map<Object, Object>memap=new HashMap<Object, Object>();
		try {
			int result=mapper.MemModi(member);
			if(result > 0)
				memap.put("100", "修改会员信息成功");
			else
				memap.put("101", "修改会员信息成功");
		} catch (Exception e) {
			//输出异常
		}
		return memap.toString();
	}

	//清除会员信息
	public String deleMem(Member member) {
		Map<Object, Object>memap=new HashMap<Object, Object>();
		try {
			int result=mapper.MemDelet(member);
			if(result > 0)
				memap.put("100", "清除会员信息成功");
			else
				memap.put("101", "清除会员信息成功");
		} catch (Exception e) {
			//输出异常
		}
		return memap.toString();
	}

}
