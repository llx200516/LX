package com.schj.entity;



/***
 * ������Ϣ��
 * @author llx
 * time 2019-10-10 AM 9:45
 * @version 1.0
 */
public class Resume {
		
	private int id; //������Ϣ���
	 
	private int memid; //��ԱCode
	
	private String intention; //��ְ����
	
	private String pectsalary; //����н��
	
	private int loffice; //�Ƿ���ְ
	
	private String sappraisal; //��������
	


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
