package com.kh.dep.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberSelect;

public interface MemberDao {

	MemberSelect selectLoginMember(SqlSessionTemplate sqlSession, MemberSelect m);

	String selectEncpassword(SqlSessionTemplate sqlSession, MemberSelect m);

	

}
