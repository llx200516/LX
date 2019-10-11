package com.schj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.schj.entity.Member;


@Mapper
@Repository
public interface MemberMapper {
	 
	
	//��Ա��Ϣά��	
	int MemInset(@Param("member")Member member);
	
	//��Ա��Ϣ���
	
	int MemDelet(@Param("member")Member member);
	
	//��Ա��Ϣ�޸�
	
	int MemModi(@Param("member")Member member);
}
