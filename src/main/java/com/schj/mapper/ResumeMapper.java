package com.schj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.schj.entity.Resume;



@Mapper
@Repository
public interface ResumeMapper {
	
	
	//根据会员id和求职意向获取简历
	//会员id和求职意向相同的简历可能不仅仅是一份，用集合获取
	List<Resume> findResIdByMemidI(@Param("memid")int memid,@Param("intention")String intention);
	
	//维护简历信息
	int inserRes(@Param("resume")Resume resume);
	
	int updatRes(@Param("resume")Resume resume);
	
	int deleRes(@Param("resume")Resume resume);
}
