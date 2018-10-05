package com.kh.dep.member.model.service;

import java.util.ArrayList;

import com.kh.dep.member.exception.LoginException;
import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;
import com.kh.dep.member.model.vo.MemberSelect;

public interface MemberService {

	MemberSelect selectLoginMember(MemberSelect m) throws LoginException;


	int updateMyInfo(MemberSelect m);

	ArrayList<MemberDepartment> selectDepList();

	ArrayList<MemberJob> selectJobList();


	int insertMember(MemberSelect m);



}
