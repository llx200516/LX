package com.schj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.schj.entity.Member;


@Mapper
@Repository
public interface MemberMapper {
	 
	
	//会员信息维护	
	int MemInset(@Param("member")Member member);
	
	//会员信息清除
	
	int MemDelet(@Param("member")Member member);
	
	//会员信息修改
	
	int MemModi(@Param("member")Member member);
}
