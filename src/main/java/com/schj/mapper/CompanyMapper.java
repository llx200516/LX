package com.schj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.schj.entity.Company;

/***
 * 
 * @author Llx	
 * @version 1.0
 * time 2019-10-09 PM 15:13
 *
 */

@Mapper
@Repository
public interface CompanyMapper {
	
	//ʹ��ע���ѯ��˾��Ϣ
	@Select("select id, comName, comscale, comAddress, involved from company ")
	List<Company> selePageCom();
	
	//ά����˾��Ϣ
	int inserComI(@Param(value = "company") Company company);
	
	//�����˾��Ϣ
	int delComD(@Param(value = "comid")int id);
	
	//�޸Ĺ�˾��Ϣ
	int modiComM(@Param(value = "company") Company company);
	
	
}
