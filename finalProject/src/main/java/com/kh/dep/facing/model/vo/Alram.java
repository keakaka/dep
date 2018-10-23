package com.kh.dep.facing.model.vo;

import org.springframework.stereotype.Repository;

@Repository
public class Alram implements java.io.Serializable {
	
	private int empNo;
	private String alramContents;
	private int alramNo;
	private String status;
	private int facingNo;
	
	public Alram(){}

	public Alram(int empNo, String alramContents, int alramNo, String status, int facingNo) {
		super();
		this.empNo = empNo;
		this.alramContents = alramContents;
		this.alramNo = alramNo;
		this.status = status;
		this.facingNo = facingNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getAlramContents() {
		return alramContents;
	}

	public void setAlramContents(String alramContents) {
		this.alramContents = alramContents;
	}

	public int getAlramNo() {
		return alramNo;
	}

	public void setAlramNo(int alramNo) {
		this.alramNo = alramNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFacingNo() {
		return facingNo;
	}

	public void setFacingNo(int facingNo) {
		this.facingNo = facingNo;
	}

	@Override
	public String toString() {
		return "Alram [empNo=" + empNo + ", alramContents=" + alramContents + ", alramNo=" + alramNo + ", status="
				+ status + ", facingNo=" + facingNo + "]";
	}

	


	
	

}
