package com.kh.dep.member.model.vo;

public class Department implements java.io.Serializable {
	private String depId;
	private String depName;
	private String depPhone;
	private String depRecordDate;
	private String depReason;
	private String empName;
	
	public Department(){}
	
	public Department(String depId, String depName, String depPhone, String depRecordDate, String depReason,
			String empName) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.depPhone = depPhone;
		this.depRecordDate = depRecordDate;
		this.depReason = depReason;
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

	public String getDepPhone() {
		return depPhone;
	}

	public void setDepPhone(String depPhone) {
		this.depPhone = depPhone;
	}

	public String getDepRecordDate() {
		return depRecordDate;
	}

	public void setDepRecordDate(String depRecordDate) {
		this.depRecordDate = depRecordDate;
	}

	public String getDepReason() {
		return depReason;
	}

	public void setDepReason(String depReason) {
		this.depReason = depReason;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + ", depPhone=" + depPhone + ", depRecordDate="
				+ depRecordDate + ", depReason=" + depReason + ", empName=" + empName + "]";
	}
	
}
