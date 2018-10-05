package com.kh.dep.calendar.model.vo;

import java.sql.Date;

public class Calendar {
	private int scheduleNo;
	private int empNo;
	private String scheduleTitle;
	private String scheduleContent;
	private Date scheStartDate;
	private Date scheEndDate;
	private String scheType;
	
	public Calendar() {}

	public Calendar(int scheduleNo, int empNo, String scheduleTitle, String scheduleContent, Date scheStartDate,
			Date scheEndDate, String scheType) {
		super();
		this.scheduleNo = scheduleNo;
		this.empNo = empNo;
		this.scheduleTitle = scheduleTitle;
		this.scheduleContent = scheduleContent;
		this.scheStartDate = scheStartDate;
		this.scheEndDate = scheEndDate;
		this.scheType = scheType;
	}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public String getScheduleTitle() {
		return scheduleTitle;
	}

	public String getScheduleContent() {
		return scheduleContent;
	}

	public Date getScheStartDate() {
		return scheStartDate;
	}

	public Date getScheEndDate() {
		return scheEndDate;
	}

	public String getScheType() {
		return scheType;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}

	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}

	public void setScheStartDate(Date scheStartDate) {
		this.scheStartDate = scheStartDate;
	}

	public void setScheEndDate(Date scheEndDate) {
		this.scheEndDate = scheEndDate;
	}

	public void setScheType(String scheType) {
		this.scheType = scheType;
	}

	@Override
	public String toString() {
		return "Calendar [scheduleNo=" + scheduleNo + ", empNo=" + empNo + ", scheduleTitle=" + scheduleTitle
				+ ", scheduleContent=" + scheduleContent + ", scheStartDate=" + scheStartDate + ", scheEndDate="
				+ scheEndDate + ", scheType=" + scheType + "]";
	}
	
}


