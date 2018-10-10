package com.kh.dep.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.member.model.vo.Department;
import com.kh.dep.member.model.vo.Job;
import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;
import com.kh.dep.member.model.vo.MemberSelect;
import com.kh.dep.member.model.vo.Position;
import com.kh.dep.member.model.vo.Vacation;
import com.kh.dep.member.model.vo.WorkingHours;

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
	public int updateMyInfo(SqlSessionTemplate sqlSession, MemberSelect m){
		
		
		return sqlSession.update("Member.updateMyInfo", m);
	}


	public ArrayList<MemberJob> selectJobList(SqlSessionTemplate sqlSession) {
		
		return (ArrayList)sqlSession.selectList("Member.selectJob");
	}

	@Override
	public List<Department> selectMyDepRecordInfo(SqlSessionTemplate sqlSession, String empId) throws Exception {
		List<Department> list = sqlSession.selectList("Member.selectMyDepRecord", empId);
		/*System.out.println(list);*/
		return list;
	}

	public int insertMember(SqlSessionTemplate sqlSession, MemberSelect m) {
		
		return sqlSession.insert("Member.insertMember", m);
	}



	@Override
	public List<Job> selectMyJobRecord(SqlSessionTemplate sqlSession, int empNo) throws Exception {
		List<Job> list = sqlSession.selectList("Member.selectMyJobRecord", empNo);
		/*System.out.println(list);*/
		return list;
	}

	@Override
	public List<Position> selectMyJobPositionRecord(SqlSessionTemplate sqlSession, int empNo) throws Exception {
		List<Position> list = sqlSession.selectList("Member.selectMyJobPositionRecord", empNo);
		return list;
	}

	@Override
	public String selectEncpassword(SqlSessionTemplate sqlSession, String empId) {
		
		return sqlSession.selectOne("Member.selectPwd2", empId);
	}

	@Override
	public int insertMyVacation(SqlSessionTemplate sqlSession, Vacation myVac) {
		
		
		return sqlSession.insert("Member.insertMyVaction", myVac);
	}

	@Override
	public List<Vacation> selectMyVacationRecrod(SqlSessionTemplate sqlSession, int empNo) {
		List<Vacation> list = sqlSession.selectList("Member.selectMyVacationRecord", empNo);
		System.out.println("나의 휴가이력(dao) : " + list);
		return list;
	}

	@Override
	public List<WorkingHours> selectMyWorkingHoursRecord(SqlSessionTemplate sqlSession, int empNo) {
		System.out.println(empNo);
		List<WorkingHours> list = sqlSession.selectList("Member.selectMyWorkingHoursRecord", empNo);
		System.out.println("나의 출퇴근이력(dao) : " + list);
		return list;
	}

	
	

}
