package com.kh.dep.personManagement.model.pmService;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.personManagement.model.pmDao.PmDao;
import com.kh.dep.personManagement.model.vo.DepLeave;
import com.kh.dep.personManagement.model.vo.DepMoveDepRecord;
import com.kh.dep.personManagement.model.vo.PromotionIn;
import com.kh.dep.personManagement.model.vo.PromotionLi;
import com.kh.dep.personManagement.model.vo.VacationIn;
import com.kh.dep.personManagement.model.vo.VacationLi;
import com.kh.dep.personManagement.model.vo.Working;


@Service
public class PmServiceImpl implements PmService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PmDao pd;
	
	
	@Override
	public ArrayList<Working> depMgtList(String depName) {
		// TODO Auto-generated method stub
		
		ArrayList<Working> list = pd.depMgtList(sqlSession,depName);
		
		return list;
	}


	@Override
	public ArrayList<Working> depMgtdayList(String day,String depName , String year) {
		// TODO Auto-generated method stub
		ArrayList<Working> list = pd.depMgtdayList(sqlSession,day,depName , year);
		
		return list;
	}


	@Override
	public ArrayList<VacationLi> vacationDayList(String day) {
		// TODO Auto-generated method stub
		
		ArrayList<VacationLi> list = pd.vacationDayList(sqlSession,day);
		return list;
	}


	@Override
	public ArrayList<VacationLi> vacationDepList(String depName) {
		// TODO Auto-generated method stub
		ArrayList<VacationLi> list = pd.vacationDepList(sqlSession,depName);
		return list;
		
	}


	@Override
	public ArrayList<PromotionLi> selectPromotionList(String depName) {
		// TODO Auto-generated method stub
		ArrayList<PromotionLi> list = pd.selectPromotionList(sqlSession,depName);
		return list;
	}


	@Override
	public ArrayList<PromotionLi> selectPromotiondayList(String day, String depName ,String year) {
		// TODO Auto-generated method stub
		ArrayList<PromotionLi> list = pd.selectPromotiondayList(sqlSession,day,depName,year);
		return list;
	}

	// 부서별 퇴사자 조회
	@Override
	public ArrayList<DepLeave> selectDepLeaveList(String depName) {
		
		ArrayList<DepLeave> dlist = null;
		
		dlist = pd.selectDepLeaveList(sqlSession, depName);
		
		return dlist;
	}


	// 부서별 월별 퇴사자 조회
	@Override
	public ArrayList<DepLeave> selectDepLeavedayList(String day, String depName, String year) {
		ArrayList<DepLeave> dlist = null;
		
		dlist = pd.selectDepLeavedayList(sqlSession, depName, day, year);
		
		return dlist;
	}


	// 부서이동이력 조회
	@Override
	public ArrayList<DepMoveDepRecord> selectDepmoveList(String depName) {
		
		ArrayList<DepMoveDepRecord> dlist = null;
		
		dlist = pd.selectDepmoveList(sqlSession, depName);
		
		return dlist;
	}


	// 월별 부서이동 이력 조회
	@Override
	public ArrayList<DepMoveDepRecord> selectDepMovedayList(String day, String depName, String year) {
		
		ArrayList<DepMoveDepRecord> dlist = null;
		
		dlist = pd.selectDepmovedayList(sqlSession, depName, day, year);
		
		return dlist;
	}


	@Override
	public ArrayList<DepMoveDepRecord> selectDepMoveEmpNoList(int empNo) {
		
		ArrayList<DepMoveDepRecord> dlist = null;
		
		dlist = pd.selectDepmoveEmpNoList(sqlSession, empNo);
		
		return dlist;
	}

	@Override
	public int insertvacation(VacationIn v) {
		// TODO Auto-generated method stub
		int result = pd.insertVacation(sqlSession,v);
		
		return result;
	}


	@Override
	public int insertpromotion(PromotionIn p) {
		// TODO Auto-generated method stub
		int result = pd.insertProomotion(sqlSession,p);
		return result;

	}


	@Override
	public ArrayList<Working> depNameList(String name) {
		// TODO Auto-generated method stub
		int empNo = Integer.parseInt(name);
		ArrayList<Working> list = pd.depNameList(sqlSession , empNo);
		
		return list;
	}

	
}
