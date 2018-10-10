package com.kh.dep.facing.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Facing implements java.io.Serializable {

	private int empNo;
	private String empName;
	private int facingNo;
	private String facingTitle;
	private String facingContents;
	private Date writeDate;
	private int receiver;
	private String status;
	private Date reciverDate;
	private int depId;
	private String depName;
	
	public Facing()
	{
		
	}
	
	public Facing(int empNo, String empName, int facingNo, String facingTitle, String facingContents, Date writeDate,
			int receiver, String status, Date reciverDate, int depId , String depName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.facingNo = facingNo;
		this.facingTitle = facingTitle;
		this.facingContents = facingContents;
		this.writeDate = writeDate;
		this.receiver = receiver;
		this.status = status;
		this.reciverDate = reciverDate;
		this.depId = depId;
		this.depName = depName;
	}

	
	public String getdepName()
	{
		return depName;
		
	}
	
	public void setdepName(String depName)
	{
		this.depName = depName;
	}
	
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getFacingNo() {
		return facingNo;
	}

	public void setFacingNo(int facingNo) {
		this.facingNo = facingNo;
	}

	public String getFacingTitle() {
		return facingTitle;
	}

	public void setFacingTitle(String facingTitle) {
		this.facingTitle = facingTitle;
	}

	public String getFacingContents() {
		return facingContents;
	}

	public void setFacingContents(String facingContents) {
		this.facingContents = facingContents;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getReciverDate() {
		return reciverDate;
	}

	public void setReciverDate(Date reciverDate) {
		this.reciverDate = reciverDate;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	@Override
	public String toString() {
		return "Facing [empNo=" + empNo + ", empName=" + empName + ", facingNo=" + facingNo + ", facingTitle="
				+ facingTitle + ", facingContents=" + facingContents + ", writeDate=" + writeDate + ", receiver="
				+ receiver + ", status=" + status + ", reciverDate=" + reciverDate + ", depId=" + depId + "]";
	}
	
}
