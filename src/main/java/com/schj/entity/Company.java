package com.schj.entity;


public class Company {
	
	private int id;// 公司code
	private String comName;// 公司名称	
	private String comscale;// 公司规模
	private String comAddress;// 公司地址
	private String involved;// 所属行业
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getComscale() {
		return comscale;
	}
	public void setComscale(String comscale) {
		this.comscale = comscale;
	}
	public String getComAddress() {
		return comAddress;
	}
	public void setComAddress(String comAddress) {
		this.comAddress = comAddress;
	}
	public String getInvolved() {
		return involved;
	}
	public void setInvolved(String involved) {
		this.involved = involved;
	}
	
}
