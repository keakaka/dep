package com.kh.dep.personManagement.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Repository;


public class personM {

	private int empNo;
	private String empId;
	private String empName;
	private String birthDate;
	private String email;
	private String phone;
	private String emergencyPhone;
	private String address;
	private int salary;
	private Date hireDate;
	private Date leaveDate;
	private String phoneReveal;
	private String status;
	private int workingRecordNo;
	private String workingDate;
	private String attendTime;
	private String leaveTime;
	private String depId;
	private String depName;
	private String depPhone;
	private String seqNum;
	private String jobRecordNo;
	private String jobName;
	private Date jobRecordDate;
	private String jobReason;
	private int vacNo;
	private String vacReason;
	private String vacType;
	private String vacStartdate;
	private String vacEnddate;
	public personM(int empNo, String empId, String empName, String birthDate, String email, String phone,
			String emergencyPhone, String address, int salary, Date hireDate, Date leaveDate, String phoneReveal,
			String status, int workingRecordNo, String workingDate, String attendTime, String leaveTime, String depId,
			String depName, String depPhone, String seqNum, String jobRecordNo, String jobName, Date jobRecordDate,
			String jobReason, int vacNo, String vacReason, String vacType, String vacStartdate, String vacEnddate) {
		super();
		this.empNo = empNo;
		this.empId = empId;
		this.empName = empName;
		this.birthDate = birthDate;
		this.email = email;
		this.phone = phone;
		this.emergencyPhone = emergencyPhone;
		this.address = address;
		this.salary = salary;
		this.hireDate = hireDate;
		this.leaveDate = leaveDate;
		this.phoneReveal = phoneReveal;
		this.status = status;
		this.workingRecordNo = workingRecordNo;
		this.workingDate = workingDate;
		this.attendTime = attendTime;
		this.leaveTime = leaveTime;
		this.depId = depId;
		this.depName = depName;
		this.depPhone = depPhone;
		this.seqNum = seqNum;
		this.jobRecordNo = jobRecordNo;
		this.jobName = jobName;
		this.jobRecordDate = jobRecordDate;
		this.jobReason = jobReason;
		this.vacNo = vacNo;
		this.vacReason = vacReason;
		this.vacType = vacType;
		this.vacStartdate = vacStartdate;
		this.vacEnddate = vacEnddate;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmergencyPhone() {
		return emergencyPhone;
	}
	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getPhoneReveal() {
		return phoneReveal;
	}
	public void setPhoneReveal(String phoneReveal) {
		this.phoneReveal = phoneReveal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getWorkingRecordNo() {
		return workingRecordNo;
	}
	public void setWorkingRecordNo(int workingRecordNo) {
		this.workingRecordNo = workingRecordNo;
	}
	public String getWorkingDate() {
		return workingDate;
	}
	public void setWorkingDate(String workingDate) {
		this.workingDate = workingDate;
	}
	public String getAttendTime() {
		return attendTime;
	}
	public void setAttendTime(String attendTime) {
		this.attendTime = attendTime;
	}
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
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
	public String getDepPhone() {
		return depPhone;
	}
	public void setDepPhone(String depPhone) {
		this.depPhone = depPhone;
	}
	public String getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}
	public String getJobRecordNo() {
		return jobRecordNo;
	}
	public void setJobRecordNo(String jobRecordNo) {
		this.jobRecordNo = jobRecordNo;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public Date getJobRecordDate() {
		return jobRecordDate;
	}
	public void setJobRecordDate(Date jobRecordDate) {
		this.jobRecordDate = jobRecordDate;
	}
	public String getJobReason() {
		return jobReason;
	}
	public void setJobReason(String jobReason) {
		this.jobReason = jobReason;
	}
	public int getVacNo() {
		return vacNo;
	}
	public void setVacNo(int vacNo) {
		this.vacNo = vacNo;
	}
	public String getVacReason() {
		return vacReason;
	}
	public void setVacReason(String vacReason) {
		this.vacReason = vacReason;
	}
	public String getVacType() {
		return vacType;
	}
	public void setVacType(String vacType) {
		this.vacType = vacType;
	}
	public String getVacStartdate() {
		return vacStartdate;
	}
	public void setVacStartdate(String vacStartdate) {
		this.vacStartdate = vacStartdate;
	}
	public String getVacEnddate() {
		return vacEnddate;
	}
	public void setVacEnddate(String vacEnddate) {
		this.vacEnddate = vacEnddate;
	}
	
	@Override
	public String toString() {
		return "personM [empNo=" + empNo + ", empId=" + empId + ", empName=" + empName + ", birthDate=" + birthDate
				+ ", email=" + email + ", phone=" + phone + ", emergencyPhone=" + emergencyPhone + ", address="
				+ address + ", salary=" + salary + ", hireDate=" + hireDate + ", leaveDate=" + leaveDate
				+ ", phoneReveal=" + phoneReveal + ", status=" + status + ", workingRecordNo=" + workingRecordNo
				+ ", workingDate=" + workingDate + ", attendTime=" + attendTime + ", leaveTime=" + leaveTime
				+ ", depId=" + depId + ", depName=" + depName + ", depPhone=" + depPhone + ", seqNum=" + seqNum
				+ ", jobRecordNo=" + jobRecordNo + ", jobName=" + jobName + ", jobRecordDate=" + jobRecordDate
				+ ", jobReason=" + jobReason + ", vacNo=" + vacNo + ", vacReason=" + vacReason + ", vacType=" + vacType
				+ ", vacStartdate=" + vacStartdate + ", vacEnddate=" + vacEnddate + "]";
	}
	
	

}
