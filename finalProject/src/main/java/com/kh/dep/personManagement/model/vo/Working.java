package com.kh.dep.personManagement.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Repository;



@Repository
public class Working implements java.io.Serializable{

	private int empNo;
	private String empName;
	private String depId;
	private String depName;
	private String today;
	private String tTime;
	private String leaveTime;
	public Working()
	{
		
	}
	public Working(int empNo, String empName, String depId, String depName,  String today, String tTime,
			String leaveTime) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.depId = depId;
		this.depName = depName;
		this.today = today;
		this.tTime = tTime;
		this.leaveTime = leaveTime;
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
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String gettTime() {
		return tTime;
	}
	public void settTime(String tTime) {
		this.tTime = tTime;
	}
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	@Override
	public String toString() {
		return "Working [empNo=" + empNo + ", empName=" + empName + ", depId=" + depId + ", depName=" + depName
				+ ", today=" + today + ", tTime=" + tTime + ", leaveTime=" + leaveTime + "]";
	}
	
	

	
	
	
	
	
	
}
