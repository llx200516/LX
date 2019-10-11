package com.schj.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.schj.entity.Position;
import com.schj.vo.PageRequest;

public interface PosServices {
		
	//��ѯallְλ
	List<Position> selectByAll();
	
	//��������ѯְλ����ҳ
	List<Position>selectByWh(@RequestParam String posName,@RequestParam String Education,@RequestParam String comBusiness);
	
	//ά��ְλ��Ϣ
	String insertpos(Position position);
	
	//���ְλ��Ϣ
	String delePos(String posid);
	
	//�޸�ְλ��Ϣ
	String updatPos(Position position);
	
	//��ѯ����ְλ��ҳ����
	PageInfo<Position> getPageInfo(PageRequest pageRequest);
	
	
	//������ѯְλ��ҳ����
	PageInfo<Position> getposCom(PageRequest pageRequest,Position position,String comName);
}
