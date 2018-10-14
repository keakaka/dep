package com.kh.dep.sign.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.sign.model.vo.InsertSign;
import com.kh.dep.sign.model.vo.MemberDep;

public interface SignDao {

	ArrayList<MemberDep> selectMemberDep(SqlSessionTemplate sqlSession, String depName);

	int insertDocApproval(SqlSessionTemplate sqlSession, InsertSign is);
	
	int insertApproval_record(SqlSessionTemplate sqlSession, InsertSign is);
	
	int insertReceiving_Check(SqlSessionTemplate sqlSession, InsertSign is);
	
	int insertAttachment(SqlSessionTemplate sqlSession, InsertSign is);

	
}
