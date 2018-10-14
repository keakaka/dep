package com.kh.dep.sign.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.dep.sign.model.dao.SignDao;
import com.kh.dep.sign.model.exception.InsertSignException;
import com.kh.dep.sign.model.vo.InsertSign;
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

	@Override
	public int insertSign(InsertSign is) throws InsertSignException{
		int result = -99;
		int result1 = sd.insertDocApproval(sqlSession, is);
		int result2 = sd.insertApproval_record(sqlSession, is);
		int result3 = sd.insertReceiving_Check(sqlSession, is);
		int result4 = sd.insertAttachment(sqlSession, is);
		
		
		if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0){
			result = 1;
			return result;
		}else{
			throw new InsertSignException("전자문서 기안 실패");
		}
		
	}
}
