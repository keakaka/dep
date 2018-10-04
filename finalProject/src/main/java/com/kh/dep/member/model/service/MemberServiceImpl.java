package com.kh.dep.member.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.dep.member.exception.LoginException;
import com.kh.dep.member.model.dao.MemberDao;
import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;
import com.kh.dep.member.model.vo.MemberSelect;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MemberDao md;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// 로그인 메소드
	@Override
	public MemberSelect selectLoginMember(MemberSelect m) throws LoginException {
		
		
		MemberSelect loginUser = null;
		
		String encPassword = md.selectEncpassword(sqlSession, m);
		
		
		if(!passwordEncoder.matches(m.getEmpPwd(), encPassword)){
			throw new LoginException("로그인 실패");
		}else{
			loginUser = md.selectLoginMember(sqlSession, m);
		}
		
		
		return loginUser;
	}

	@Override
	public int updateMyInfo(MemberSelect m) {
		
		return md.updateMyInfo(sqlSession, m);
	}

  
	public ArrayList<MemberDepartment> selectDepList() {
		
		ArrayList<MemberDepartment> deplist = md.selectdepList(sqlSession);
		
		
		return deplist;
	}

	@Override
	public ArrayList<MemberJob> selectJobList() {
		
		ArrayList<MemberJob> joblist = md.selectJobList(sqlSession);
		
		return joblist;
	}

	
}
