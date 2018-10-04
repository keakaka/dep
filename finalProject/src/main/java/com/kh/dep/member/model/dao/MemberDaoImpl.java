package com.kh.dep.member.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;
import com.kh.dep.member.model.vo.MemberSelect;

@Repository
public class MemberDaoImpl implements MemberDao {

	// 로그인 메소드
	@Override
	public MemberSelect selectLoginMember(SqlSessionTemplate sqlSession, MemberSelect m) {
			
			return sqlSession.selectOne("Member.selectLoginUser", m);
	
	}	

	//암호화 패스워드 조회
	@Override
	public String selectEncpassword(SqlSessionTemplate sqlSession, MemberSelect m) {
		
		return sqlSession.selectOne("Member.selectPwd", m.getEmpId());
	}

	@Override
	public ArrayList<MemberDepartment> selectdepList(SqlSessionTemplate sqlSession) {
		
		
		
		return (ArrayList)sqlSession.selectList("Member.selectDep");
	}

	@Override
	public int updateMyInfo(SqlSessionTemplate sqlSession, MemberSelect m) {
		
		
		return sqlSession.update("MemberSelect.updateMyInfo", m);
	}


	public ArrayList<MemberJob> selectJobList(SqlSessionTemplate sqlSession) {
		
		return (ArrayList)sqlSession.selectList("Member.selectJob");
	}


	

}
