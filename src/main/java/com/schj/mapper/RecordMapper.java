package com.schj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.schj.entity.Record;





@Mapper
@Repository
public interface RecordMapper {
	
	
	//根据会员和职位code查看是否投递职位
	
	Record checkRecByMidPosId(@Param("memid")int memid,@Param("posid")int posid);
	
	//简历投递
	
	int Icord(@Param("record")Record record);
	
	//简历结果审评
	int RecresultModi(@Param("record")Record record);
	
	//
	List<Record> seleAllr(@Param("posName")String posName,@Param("comName")String comName);
	
	//导出Excel查询
	List<Record> reexcel();
	
	
	//统计已投递的人数
	int toudisum(@Param("posName")String posName,@Param("comName")String comName);
	
	//统计已面试的人数
	int mianssum(@Param("posName")String posName,@Param("comName")String comName);
	
	//统计已通过的人数
	int tonggsum(@Param("posName")String posName,@Param("comName")String comName);
}	
