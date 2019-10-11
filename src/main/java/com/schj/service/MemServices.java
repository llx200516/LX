package com.schj.service;

import com.schj.entity.Member;

public interface MemServices {
		
	//维护会员信息
	String inetMem(Member member);
	//修改会员信息
	String updatMem(Member member);
	//清除会员信息
	String deleMem(Member member);
}
