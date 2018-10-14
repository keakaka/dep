package com.kh.dep.sign.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.sign.model.dao.SignDao;
import com.kh.dep.sign.model.vo.MemberDep;

@Service
public class SignServiceImpl implements SignService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private SignDao sd;

	@Override
	public ArrayList<MemberDep> selectMemberDep(String depName) {
		
		return sd.selectMemberDep(sqlSession, depName);
	}
}
