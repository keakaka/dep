package com.kh.dep.member.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.dep.member.exception.LoginException;
import com.kh.dep.member.model.vo.Department;
import com.kh.dep.member.model.vo.Job;
import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;
import com.kh.dep.member.model.vo.MemberSelect;
import com.kh.dep.member.model.vo.Position;

public interface MemberService {

	MemberSelect selectLoginMember(MemberSelect m) throws LoginException;


	int updateMyInfo(MemberSelect m) throws Exception;

	ArrayList<MemberDepartment> selectDepList();

	ArrayList<MemberJob> selectJobList();
	
	public List<Department> selectMyDepRecordInfo(String empId) throws Exception;


	List<Job> selectMyJobRecord(int empNo) throws Exception;


	List<Position> selectMyJobPositionRecord(int empNo) throws Exception;


	MemberSelect selectUpdateMember(MemberSelect m) throws Exception;


	boolean checkPw(MemberSelect m);


	int insertMember(MemberSelect m);


	int selectempNumber();


	ArrayList<Position> selectpositList();



}
