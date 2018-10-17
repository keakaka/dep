package com.kh.dep.personManagement.model.pmService;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.personManagement.model.pmDao.PmDao;
import com.kh.dep.personManagement.model.vo.PromotionLi;
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
		
		System.out.println("근태 서비스 입장");
		ArrayList<Working> list = pd.depMgtList(sqlSession,depName);
		
		System.out.println(list);
		return list;
	}


	@Override
	public ArrayList<Working> depMgtdayList(String day,String depName , String year) {
		// TODO Auto-generated method stub
		System.out.println("근태 월별 서비스 입장");
		ArrayList<Working> list = pd.depMgtdayList(sqlSession,day,depName , year);
		
		System.out.println(list);
		return list;
	}


	@Override
	public ArrayList<VacationLi> vacationDayList(String day) {
		// TODO Auto-generated method stub
		System.out.println("휴가 월별 리스트 입장");
		
		ArrayList<VacationLi> list = pd.vacationDayList(sqlSession,day);
		System.out.println("휴가 월별 List :" + list);
		return list;
	}


	@Override
	public ArrayList<VacationLi> vacationDepList(String depName) {
		// TODO Auto-generated method stub
		System.out.println("휴가 부서별 리스트 입장");
		ArrayList<VacationLi> list = pd.vacationDepList(sqlSession,depName);
		System.out.println("휴가 월별 List :" + list);
		return list;
		
	}


	@Override
	public ArrayList<PromotionLi> selectPromotionList(String depName) {
		// TODO Auto-generated method stub
		System.out.println("진급 부서별 리스트 입장");
		ArrayList<PromotionLi> list = pd.selectPromotionList(sqlSession,depName);
		System.out.println("진급 부서별 List :" + list);
		return list;
	}


	@Override
	public ArrayList<PromotionLi> selectPromotiondayList(String day, String depName ,String year) {
		// TODO Auto-generated method stub
		System.out.println("진급 부서별 리스트 입장");
		ArrayList<PromotionLi> list = pd.selectPromotiondayList(sqlSession,day,depName,year);
		System.out.println("진급 월별 List :" + list);
		return list;
	}

	
}
