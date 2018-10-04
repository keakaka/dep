package com.kh.dep.member.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class MemberSelect implements java.io.Serializable {

	private int empNo;
	private String empId;
	private String empPwd;
	private String empName;
	private String depName;
	private String jobName;
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
	private String jobCode;
	private String depId;
	private String oriFileName;
	private String empType;
	
	public MemberSelect(){}

	


	public MemberSelect(int empNo, String empId, String empPwd, String empName, String depName, String jobName,
			String birthDate, String email, String phone, String emergencyPhone, String address, int salary,
			Date hireDate, Date leaveDate, String phoneReveal, String status, String jobCode, String depId,
			String oriFileName, String empType) {
		super();
		this.empNo = empNo;
		this.empId = empId;
		this.empPwd = empPwd;
		this.empName = empName;
		this.depName = depName;
		this.jobName = jobName;
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
		this.jobCode = jobCode;
		this.depId = depId;
		this.oriFileName = oriFileName;
		this.empType = empType;
	}









	@Override
	public String toString() {
		return "MemberSelect [empNo=" + empNo + ", empId=" + empId + ", empPwd=" + empPwd + ", empName=" + empName
				+ ", depName=" + depName + ", jobName=" + jobName + ", birthDate=" + birthDate + ", email=" + email
				+ ", phone=" + phone + ", emergencyPhone=" + emergencyPhone + ", address=" + address + ", salary="
				+ salary + ", hireDate=" + hireDate + ", leaveDate=" + leaveDate + ", phoneReveal=" + phoneReveal
				+ ", status=" + status + ", jobCode=" + jobCode + ", depId=" + depId + ", oriFileName=" + oriFileName
				+ ", empType=" + empType + "]";
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

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
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
	
	public String getJobCode() {
		return jobCode;
	}



	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}



	public String getDepId() {
		return depId;
	}



	public void setDepId(String depId) {
		this.depId = depId;
	}




	public String getOriFileName() {
		return oriFileName;
	}




	public void setOriFileName(String oriFileName) {
		this.oriFileName = oriFileName;
	}


	public String getEmpType() {
		return empType;
	}


	public void setEmpType(String empType) {
		this.empType = empType;
	}
	
	
	
	
}
