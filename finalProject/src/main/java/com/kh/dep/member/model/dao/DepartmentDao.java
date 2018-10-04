package com.kh.dep.member.model.dao;

import java.util.List;

import com.kh.dep.member.model.vo.Department;

public interface DepartmentDao {
	public List<Department> selectMyDepRecordInfo() throws Exception;
}
