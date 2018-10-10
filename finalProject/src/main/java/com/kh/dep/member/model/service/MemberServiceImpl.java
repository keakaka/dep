package com.kh.dep.member.model.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.dep.member.exception.LoginException;
import com.kh.dep.member.model.dao.MemberDao;
import com.kh.dep.member.model.vo.Department;
import com.kh.dep.member.model.vo.Job;
import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;
import com.kh.dep.member.model.vo.MemberSelect;
import com.kh.dep.member.model.vo.Position;

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
	public int updateMyInfo(MemberSelect m) throws Exception{

		return md.updateMyInfo(sqlSession, m);
	}

	// 부서목록 조회
	public ArrayList<MemberDepartment> selectDepList() {

		ArrayList<MemberDepartment> deplist = md.selectdepList(sqlSession);


		return deplist;
	}

	// 직급 목록 조회
	@Override
	public ArrayList<MemberJob> selectJobList() {

		ArrayList<MemberJob> joblist = md.selectJobList(sqlSession);

		return joblist;
	}

	@Override
	public List<Department> selectMyDepRecordInfo(String empId) throws Exception {
		return md.selectMyDepRecordInfo(sqlSession, empId);
	}

	@Override
	public List<Job> selectMyJobRecord(int empNo) throws Exception {
		return md.selectMyJobRecord(sqlSession, empNo);
	}

	@Override
	public List<Position> selectMyJobPositionRecord(int empNo) throws Exception {

		return md.selectMyJobPositionRecord(sqlSession, empNo);
	}

	@Override
	public MemberSelect selectUpdateMember(MemberSelect m) throws Exception {
		MemberSelect loginUser = null;

		String encPassword = md.selectEncpassword(sqlSession, m);

		if(!passwordEncoder.matches(m.getEmpPwd(), encPassword)){
			throw new LoginException("비밀번호가 일치하지 않습니다.");
		}else{
			loginUser = md.selectLoginMember(sqlSession, m);
		}

		return loginUser;
	}

	@Override
	public boolean checkPw(MemberSelect m) {
		boolean result = false;
		
		String encPwd = md.selectEncpassword(sqlSession, m);
		
		if(!passwordEncoder.matches(m.getEmpPwd(), encPwd)){
			/*throw new LoginException("비밀번호가 일치하지 않습니다.");*/
			System.out.println("비밀번호 불일치");
		}else{
			result = true;
			
		}
		return result;
		}
		return result;
	}

	// 사원 정보 입력
	public int insertMember(MemberSelect m) {
		
		int result = 0;
		
		int login = md.insertMember(sqlSession, m);
		
		if(login > 0){
			
		
		}

		
		return md.insertMember(sqlSession, m);
	}

	// 사원정보 입력 시 사원번호 조회
	@Override
	public int selectempNumber() {
		
		
		
		return md.selectempNumber(sqlSession);
	}

	// 직책 목록 조회
	@Override
	public ArrayList<Position> selectpositList() {
		
		ArrayList<Position> polist = null;
		
		polist = md.selectposiList(sqlSession);
		
		return polist;
	}
}
