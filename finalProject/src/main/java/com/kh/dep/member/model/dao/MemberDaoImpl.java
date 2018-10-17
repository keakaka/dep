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
import com.kh.dep.member.model.vo.SalaryExcel;
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

	// 부서 목록 조회
	@Override
	public ArrayList<MemberDepartment> selectdepList(SqlSessionTemplate sqlSession) {
		
	
		return (ArrayList)sqlSession.selectList("Member.selectDep");
	}

	@Override
	public int updateMyInfo(SqlSessionTemplate sqlSession, MemberSelect m){
		
		
		return sqlSession.update("Member.updateMyInfo", m);
	}

	// 직급 목록 조회
	public ArrayList<MemberJob> selectJobList(SqlSessionTemplate sqlSession) {
		
		return (ArrayList)sqlSession.selectList("Member.selectJob");
	}

	@Override
	public List<Department> selectMyDepRecordInfo(SqlSessionTemplate sqlSession, String empId) throws Exception {
		List<Department> list = sqlSession.selectList("Member.selectMyDepRecord", empId);
		/*System.out.println(list);*/
		return list;
	}

	// 사원 정보 입력
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

	// 사원정보 입력 시 사원 번호 조회
	@Override
	public int selectempNumber(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("Member.selectempNumber");
	}

	// 직책 목록 조회
	@Override
	public ArrayList<Position> selectposiList(SqlSessionTemplate sqlSession) {
		
		return (ArrayList)sqlSession.selectList("Member.selectPosition");
	}

	// 부서이동 이력 입력
	@Override
	public int insertDepRecord(SqlSessionTemplate sqlSession, MemberSelect m) {
		
		
		return sqlSession.insert("Member.insertDepRecord", m);
	}

	// 직책변경 이력 입력
	@Override
	public int insertPositRecord(SqlSessionTemplate sqlSession, MemberSelect m) {
		
		
		return sqlSession.insert("Member.insertPositRecord", m);
	}

	// 직급변경 이력 입력
	@Override
	public int insertJobRecord(SqlSessionTemplate sqlSession, MemberSelect m) {
		
		return sqlSession.insert("Member.insertJobRecord", m);
	}



	@Override
	public int updateMyImage(SqlSessionTemplate sqlSession, int empNo, String newFileName, String originFileName) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(empNo);
		list.add(newFileName);
		list.add(originFileName);
		
		return sqlSession.update("Member.updateMyImageFile", list);
	}

	@Override
	public List<SalaryExcel> xlsExcelReader(SqlSessionTemplate sqlSession, List<SalaryExcel> list) {
		System.out.println("급여 엑셀(xls) 업로드파일 다오 호출");
		int result = sqlSession.insert("Member.insertSalaryExcel", list); 
		System.out.println(result);
		List<SalaryExcel> result2 = new ArrayList<SalaryExcel>();
		
		if(result > 0){
			
			result2 = sqlSession.selectList("Member.selectSalaryList");
			
		}
		
		return result2;
	}

	@Override
	public List<SalaryExcel> xlsxExcelReader(SqlSessionTemplate sqlSession, List<SalaryExcel> list) {
		System.out.println("급여 엑셀(xlsx) 업로드파일 다오 호출");
		System.out.println("00"+list);
		//int result = sqlSession.insert("Member.insertSalaryExcel", list); 
		
		int result=0;
		
		for(int i=0;i<list.size();i++){
			result = sqlSession.insert("Member.insertSalaryExcel", list.get(i)); 
		}
		
		System.out.println(result);
		List<SalaryExcel> result2 = new ArrayList<SalaryExcel>();
		
		if(result > 0){
			result2 = sqlSession.selectList("Member.selectSalaryList");
		}
		
		return result2;
	}
	
	

}
