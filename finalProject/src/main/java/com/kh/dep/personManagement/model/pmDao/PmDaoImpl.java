package com.kh.dep.personManagement.model.pmDao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.dep.personManagement.model.vo.DepLeave;
import com.kh.dep.personManagement.model.vo.PromotionLi;
import com.kh.dep.personManagement.model.vo.VacationLi;
import com.kh.dep.personManagement.model.vo.Working;


@Repository
public class PmDaoImpl implements PmDao {

	
	@Override
	public ArrayList<Working> depMgtList(SqlSessionTemplate sqlSession, String depName) {
		// TODO Auto-generated method stub
		
		System.out.println("근태 다오 입장");
		ArrayList<Working> list = (ArrayList) sqlSession.selectList("Working.workingSelectList" , depName);
		
		System.out.println(list);
		return list;
	}

	@Override
	public ArrayList<Working> depMgtdayList(SqlSessionTemplate sqlSession, String day,String depName , String year) {
		// TODO Auto-generated method stub
		System.out.println("근태 다오 입장");
		Working workingLi = new Working();
		workingLi.setDay(day);
		workingLi.setYear(year);
		workingLi.setDepName(depName);
		ArrayList<Working> list = (ArrayList) sqlSession.selectList("Working.workingdaySelectList",workingLi);
		
		return list;
	}

	@Override
	public ArrayList<VacationLi> vacationDayList(SqlSessionTemplate sqlSession, String day) {
		// TODO Auto-generated method stub
		System.out.println("휴가 월별 다오 입장");
		ArrayList<VacationLi> list = (ArrayList) sqlSession.selectList("Working.vacationDaySelectList",day);
		System.out.println("월별 돌아온 리스트값" + list);
		return list;
	}

	@Override
	public ArrayList<VacationLi> vacationDepList(SqlSessionTemplate sqlSession, String depName) {
		// TODO Auto-generated method stub
		System.out.println("휴가 부서별 다오 입장");
		ArrayList<VacationLi> list = (ArrayList) sqlSession.selectList("Working.vacationDepSelectList",depName);
		System.out.println("부서별 돌아온 리스트값" + list);
		return list;
	}

	@Override
	public ArrayList<PromotionLi> selectPromotionList(SqlSessionTemplate sqlSession, String depName) {
		// TODO Auto-generated method stub
		System.out.println("진급 부서별 다오 입장");
		ArrayList<PromotionLi> list = (ArrayList) sqlSession.selectList("Working.promotionDepSelectList",depName);
		System.out.println("부서별 돌아온 리스트값" + list);
		return list;
	}

	@Override
	public ArrayList<PromotionLi> selectPromotiondayList(SqlSessionTemplate sqlSession, String day ,String depName ,String year) {
		// TODO Auto-generated method stub
		System.out.println("진급 날짜 부서별 다오 입장");
		
		PromotionLi Promotion = new PromotionLi();
		
		Promotion.setDay(day);
		Promotion.setDepName(depName);
		Promotion.setYear(year);
		ArrayList<PromotionLi> list = (ArrayList) sqlSession.selectList("Working.promotionDaySelectList",Promotion);
		
		System.out.println("부서별 돌아온 리스트값" + list);
		
		return list;
	}

	// 부서별 퇴사자 조회
	@Override
	public ArrayList<DepLeave> selectDepLeaveList(SqlSessionTemplate sqlSession, String depName) {
		
		
		
		return (ArrayList)sqlSession.selectList("Working.selectDepLeaveList", depName);
	}

	// 부서별 월별 퇴사자 조회
	@Override
	public ArrayList<DepLeave> selectDepLeavedayList(SqlSessionTemplate sqlSession, String depName, String day,
			String year) {
		
		DepLeave dl = new DepLeave();
		
		dl.setDepName(depName);
		dl.setDay(day);
		dl.setYear(year);
		
		return (ArrayList)sqlSession.selectList("Working.selectDepLeavedayList" , dl);
	}

	

}
