package com.schj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.schj.entity.Position;

@Mapper
@Repository
public interface PositionMapper {
		
	 //查询所有职位表信息
	  List<Position> selectByAllPos();
	 
	 //分页查询职位表
	  List<Position> selectPosPage();
	 
	 //职位名称 学历 公司性质 条件检索
	  List<Position>selectByWh(@Param("posName")String posName,@Param("Education") String Education,@Param("comBusiness") String comBusiness);
	 
	 //维护职位表信息
	  int insertPos(@Param("position")Position position);
	 
	 //清除一条职位
	  int delectPos(@Param("posid")int posid);
	  
	  //修改职位信息
	  int updatPos(@Param("position")Position position);
	  
	  
	  //职位表and公司表联合条件检索
	  List<Position>posComLh(@Param("position")Position position,@Param("comName")String comName);
	  
	  //根据职位的名称去查找职位id
	  Position selectPosidByComName(@Param(value = "posName")String posName);
	  
	  //根据职位id去修改招聘人数
	  int recuMberByid(@Param("recnumber")int recnumber,@Param("id")int id);
	  
	  //根据id获取记录
	  Position resultById(@Param("id")int id);
}
