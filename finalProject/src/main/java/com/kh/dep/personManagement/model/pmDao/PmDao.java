package com.kh.dep.personManagement.model.pmDao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.personManagement.model.vo.PromotionLi;
import com.kh.dep.personManagement.model.vo.VacationLi;
import com.kh.dep.personManagement.model.vo.Working;

public interface PmDao {

	ArrayList<Working> depMgtList(SqlSessionTemplate sqlSession, String depName);

	ArrayList<Working> depMgtdayList(SqlSessionTemplate sqlSession, String day ,String depName , String year);

	ArrayList<VacationLi> vacationDayList(SqlSessionTemplate sqlSession, String day);

	ArrayList<VacationLi> vacationDepList(SqlSessionTemplate sqlSession, String depName);

	ArrayList<PromotionLi> selectPromotionList(SqlSessionTemplate sqlSession, String depName);

	ArrayList<PromotionLi> selectPromotiondayList(SqlSessionTemplate sqlSession, String day , String depName , String year);

}
