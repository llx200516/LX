package com.schj.entity;


/***
 * 会员表
 * @author Llx
 * time 2019-10-10 AM 9:35
 * @version 1.0
 */
public class Member {
	
	private int id;  //会员编号	
	
	private String name; //会员名称
	
	private String phone;  //手机号
	
	private String awork;  //工作年限

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAwork() {
		return awork;
	}

	public void setAwork(String awork) {
		this.awork = awork;
	}
	
	
}
