package com.kh.dep.member.model.vo;

public class SalaryExcel {
	private String depName;
	private String jobName;
	private String empName;
	private String incomeDate;
	private String basePay;
	private String regularBonus;
	
	public SalaryExcel(){}

	public SalaryExcel(String depName, String jobName, String empName, String incomeDate, String basePay,
			String regularBonus) {
		super();
		this.depName = depName;
		this.jobName = jobName;
		this.empName = empName;
		this.incomeDate = incomeDate;
		this.basePay = basePay;
		this.regularBonus = regularBonus;
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

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}

	public String getBasePay() {
		return basePay;
	}

	public void setBasePay(String basePay) {
		this.basePay = basePay;
	}

	public String getRegularBonus() {
		return regularBonus;
	}

	public void setRegularBonus(String regularBonus) {
		this.regularBonus = regularBonus;
	}

	@Override
	public String toString() {
		return "SalaryExcel [depName=" + depName + ", jobName=" + jobName + ", empName=" + empName + ", incomeDate="
				+ incomeDate + ", basePay=" + basePay + ", regularBonus=" + regularBonus + "]";
	}

	
}