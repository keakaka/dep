package com.kh.dep.depEmergency.model.vo;

import org.springframework.stereotype.Repository;

@Repository
public class DepE {
	private String empName;
	private String jobName;
	private String depName;
	private String emergencyPhone;
	
public DepE()
{
	
}

public DepE(String empName, String jobName, String depName, String emergencyPhone) {
	super();
	this.empName = empName;
	this.jobName = jobName;
	this.depName = depName;
	this.emergencyPhone = emergencyPhone;
}


public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getJobName() {
	return jobName;
}

public void setJobName(String jobName) {
	this.jobName = jobName;
}

public String getDepName() {
	return depName;
}

public void setDepName(String depName) {
	this.depName = depName;
}

public String getEmergencyPhone() {
	return emergencyPhone;
}

public void setEmergencyPhone(String emergencyPhone) {
	this.emergencyPhone = emergencyPhone;
}



@Override
public String toString() {
	return "depE [empName=" + empName + ", jobName=" + jobName + ", depName=" + depName + ", emergencyPhone="
			+ emergencyPhone + "]";
}



}
