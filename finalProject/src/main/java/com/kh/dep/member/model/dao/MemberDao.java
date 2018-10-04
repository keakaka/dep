package com.kh.dep.member.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;
import com.kh.dep.member.model.vo.MemberSelect;

public interface MemberDao {

	MemberSelect selectLoginMember(SqlSessionTemplate sqlSession, MemberSelect m);

	String selectEncpassword(SqlSessionTemplate sqlSession, MemberSelect m);


	int updateMyInfo(SqlSessionTemplate sqlSession, MemberSelect m);

	ArrayList<MemberDepartment> selectdepList(SqlSessionTemplate sqlSession);

	ArrayList<MemberJob> selectJobList(SqlSessionTemplate sqlSession);


	

}
