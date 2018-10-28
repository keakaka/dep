package com.kh.dep.member.model.vo;

public class Alarm {
	private int alarmNo;
	private String alarmContents;
	private int empNo;
	private String empName;
	private int alarmCount;
	
	public Alarm(){}
	
	public Alarm(int alarmNo, String alarmContents, int empNo, String empName, int alarmCount) {
		super();
		this.alarmNo = alarmNo;
		this.alarmContents = alarmContents;
		this.empNo = empNo;
		this.empName = empName;
		this.alarmCount = alarmCount;
	}

	public int getAlarmNo() {
		return alarmNo;
	}

	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}

	public String getAlarmContents() {
		return alarmContents;
	}

	public void setAlarmContents(String alarmContents) {
		this.alarmContents = alarmContents;
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
	
	public int getAlarmCount() {
		return alarmCount;
	}
	
	public void setAlarmCount(int alarmCount) {
		this.alarmCount = alarmCount;
	}

	@Override
	public String toString() {
		return "Alarm [alarmNo=" + alarmNo + ", alarmContents=" + alarmContents + ", empNo=" + empNo + ", empName="
				+ empName + ", alarmCount=" + alarmCount +"]";
	}

}
