package com.kh.dep.sign.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.sign.model.vo.MemberDep;

public interface SignDao {

	ArrayList<MemberDep> selectMemberDep(SqlSessionTemplate sqlSession, String dep);
	
}
