package com.schj.entity;


/***
 * 简历记录信息表
 * @author llx
 * time 2019-10-10 AM9:40
 * @version 1.0
 * 
 */
public class Record {
	
	private int id;  //简历记录信息表
	
	private int memid; //会员ID
	
	private int resid; //简历ID
	
	private int posid; //职位ID
	
	private String sendtime;  //投递时间
	
	private int result;  //面试结果
	
	private Member member; //关联会员表
	
	private Position position; //关联职位表
	
	
	
	
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	private Resume resume; //关联简历表
	

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

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

	public int getResid() {
		return resid;
	}

	public void setResid(int resid) {
		this.resid = resid;
	}

	public int getPosid() {
		return posid;
	}

	public void setPosid(int posid) {
		this.posid = posid;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
