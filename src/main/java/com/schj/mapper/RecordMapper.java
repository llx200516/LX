package com.schj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.schj.entity.Record;





@Mapper
@Repository
public interface RecordMapper {
	
	
	//���ݻ�Ա��ְλcode�鿴�Ƿ�Ͷ��ְλ
	
	Record checkRecByMidPosId(@Param("memid")int memid,@Param("posid")int posid);
	
	//����Ͷ��
	
	int Icord(@Param("record")Record record);
	
	//�����������
	int RecresultModi(@Param("record")Record record);
	
	//
	List<Record> seleAllr(@Param("posName")String posName,@Param("comName")String comName);
	
	//����Excel��ѯ
	List<Record> reexcel();
	
	
	//ͳ����Ͷ�ݵ�����
	int toudisum(@Param("posName")String posName,@Param("comName")String comName);
	
	//ͳ�������Ե�����
	int mianssum(@Param("posName")String posName,@Param("comName")String comName);
	
	//ͳ����ͨ��������
	int tonggsum(@Param("posName")String posName,@Param("comName")String comName);
}	
