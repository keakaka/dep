package com.kh.dep.addressBook.model.vo;

import org.springframework.stereotype.Repository;

@Repository
public class AddressBook implements  java.io.Serializable{
	private int empNo;
	private String depName;
	private String empName;
	private String jobName;
	private String positionName;
	private String phone;
	private String email;
	
	public AddressBook() {}

	public AddressBook(int empNo, String depName, String empName, String jobName, String positionName, String phone,
			String email) {
		super();
		this.empNo = empNo;
		this.depName = depName;
		this.empName = empName;
		this.jobName = jobName;
		this.positionName = positionName;
		this.phone = phone;
		this.email = email;
	}

	public int getEmpNo() {
		return empNo;
	}

	public String getDepName() {
		return depName;
	}

	public String getEmpName() {
		return empName;
	}

	public String getJobName() {
		return jobName;
	}

	public String getPositionName() {
		return positionName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AddressBook [empNo=" + empNo + ", depName=" + depName + ", empName=" + empName + ", jobName=" + jobName
				+ ", positionName=" + positionName + ", phone=" + phone + ", email=" + email + "]";
	}

	

}
