package com.schj.entity;


/**
 * 
 * @author SXJ
 * @version 1.0
 *
 */
public class Position {
		
	//��˾��Bean
	
	private int id; //����
	private String posName;//ְλ����
	private String comid;//��˾���
	private String salary;//н�ʷ�Χ
	private String comBusiness;//��˾
	private String awork;//��������
	private String education;//ѧ��
	private int recnumber;//��Ƹ����
	private String redate;//��������
	
	private Company company;
	
	
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getComBusiness() {
		return comBusiness;
	}
	public void setComBusiness(String comBusiness) {
		this.comBusiness = comBusiness;
	}
	public String getAwork() {
		return awork;
	}
	public void setAwork(String awork) {
		this.awork = awork;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public int getRecnumber() {
		return recnumber;
	}
	public void setRecnumber(int recnumber) {
		this.recnumber = recnumber;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
}
