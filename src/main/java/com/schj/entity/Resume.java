package com.schj.entity;



/***
 * 简历信息表
 * @author llx
 * time 2019-10-10 AM 9:45
 * @version 1.0
 */
public class Resume {
		
	private int id; //简历信息编号
	 
	private int memid; //会员Code
	
	private String intention; //求职意向
	
	private String pectsalary; //期望薪资
	
	private int loffice; //是否在职
	
	private String sappraisal; //自我评价
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemid() {
		return memid;
	}

	public void setMemid(int memid) {
		this.memid = memid;
	}

	public String getIntention() {
		return intention;
	}

	public void setIntention(String intention) {
		this.intention = intention;
	}

	public String getPectsalary() {
		return pectsalary;
	}

	public void setPectsalary(String pectsalary) {
		this.pectsalary = pectsalary;
	}

	public int getLoffice() {
		return loffice;
	}

	public void setLoffice(int loffice) {
		this.loffice = loffice;
	}

	public String getSappraisal() {
		return sappraisal;
	}

	public void setSappraisal(String sappraisal) {
		this.sappraisal = sappraisal;
	}
	
	
}
