package com.kh.dep.sign.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Proceeding implements java.io.Serializable{
	
	private int proceedNo;
	private int empNo;
	private String roomName;
	private String roomContent;
	private Date saveDate;
	private String status;
	
	public Proceeding(){}

	public Proceeding(int proceedNo, int empNo, String roomName, String roomContent, Date saveDate, String status) {
		super();
		this.proceedNo = proceedNo;
		this.empNo = empNo;
		this.roomName = roomName;
		this.roomContent = roomContent;
		this.saveDate = saveDate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Proceeding [proceedNo=" + proceedNo + ", empNo=" + empNo + ", roomName=" + roomName + ", roomContent=" + roomContent + ", saveDate="
				+ saveDate + ", status=" + status + "]";
	}

	public int getProceedNo() {
		return proceedNo;
	}

	public void setProceedNo(int proceedNo) {
		this.proceedNo = proceedNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public String getRoomContent() {
		return roomContent;
	}
	
	public void setRoomContent(String roomContent) {
		this.roomContent = roomContent;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
