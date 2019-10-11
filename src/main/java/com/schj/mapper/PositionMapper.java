package com.schj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.schj.entity.Position;

@Mapper
@Repository
public interface PositionMapper {
		
	 //��ѯ����ְλ����Ϣ
	  List<Position> selectByAllPos();
	 
	 //��ҳ��ѯְλ��
	  List<Position> selectPosPage();
	 
	 //ְλ���� ѧ�� ��˾���� ��������
	  List<Position>selectByWh(@Param("posName")String posName,@Param("Education") String Education,@Param("comBusiness") String comBusiness);
	 
	 //ά��ְλ����Ϣ
	  int insertPos(@Param("position")Position position);
	 
	 //���һ��ְλ
	  int delectPos(@Param("posid")int posid);
	  
	  //�޸�ְλ��Ϣ
	  int updatPos(@Param("position")Position position);
	  
	  
	  //ְλ��and��˾��������������
	  List<Position>posComLh(@Param("position")Position position,@Param("comName")String comName);
	  
	  //����ְλ������ȥ����ְλid
	  Position selectPosidByComName(@Param(value = "posName")String posName);
	  
	  //����ְλidȥ�޸���Ƹ����
	  int recuMberByid(@Param("recnumber")int recnumber,@Param("id")int id);
	  
	  //����id��ȡ��¼
	  Position resultById(@Param("id")int id);
}
