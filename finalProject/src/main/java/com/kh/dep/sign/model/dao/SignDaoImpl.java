package com.kh.dep.sign.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.sign.model.vo.MemberDep;

@Repository
public class SignDaoImpl implements SignDao{


	@Override
	public ArrayList<MemberDep> selectMemberDep(SqlSessionTemplate sqlSession, String depName) {
		
		return (ArrayList)sqlSession.selectList("sign.selectMemberDep", depName);
	}
	
}
