package com.schj.entity;


/***
 * ������¼��Ϣ��
 * @author llx
 * time 2019-10-10 AM9:40
 * @version 1.0
 * 
 */
public class Record {
	
	private int id;  //������¼��Ϣ��
	
	private int memid; //��ԱID
	
	private int resid; //����ID
	
	private int posid; //ְλID
	
	private String sendtime;  //Ͷ��ʱ��
	
	private int result;  //���Խ��
	
	private Member member; //������Ա��
	
	private Position position; //����ְλ��
	
	
	
	
	
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

	private Resume resume; //����������
	

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
