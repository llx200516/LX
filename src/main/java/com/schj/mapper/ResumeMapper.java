package com.schj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.schj.entity.Resume;



@Mapper
@Repository
public interface ResumeMapper {
	
	
	//���ݻ�Աid����ְ�����ȡ����
	//��Աid����ְ������ͬ�ļ������ܲ�������һ�ݣ��ü��ϻ�ȡ
	List<Resume> findResIdByMemidI(@Param("memid")int memid,@Param("intention")String intention);
	
	//ά��������Ϣ
	int inserRes(@Param("resume")Resume resume);
	
	int updatRes(@Param("resume")Resume resume);
	
	int deleRes(@Param("resume")Resume resume);
}
