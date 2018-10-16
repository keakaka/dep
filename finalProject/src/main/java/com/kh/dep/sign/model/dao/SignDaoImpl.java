package com.kh.dep.sign.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.sign.model.vo.InsertSign;
import com.kh.dep.sign.model.vo.MemberDep;

@Repository
public class SignDaoImpl implements SignDao{


	@Override
	public ArrayList<MemberDep> selectMemberDep(SqlSessionTemplate sqlSession, String depName) {
		
		return (ArrayList)sqlSession.selectList("sign.selectMemberDep", depName);
	}

	@Override
	public int insertDocApproval(SqlSessionTemplate sqlSession, InsertSign is) {
		return sqlSession.insert("sign.insertDocApproval", is);
	}

	@Override
	public int insertApproval_record(SqlSessionTemplate sqlSession, InsertSign is) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertReceiving_Check(SqlSessionTemplate sqlSession, InsertSign is) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAttachment(SqlSessionTemplate sqlSession, InsertSign is) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
