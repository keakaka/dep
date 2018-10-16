package com.kh.dep.personManagement.model.pmDao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.personManagement.model.vo.Working;

public interface PmDao {

	ArrayList<Working> depMgtList(SqlSessionTemplate sqlSession, String depName);

	ArrayList<Working> depMgtdayList(SqlSessionTemplate sqlSession, String day);

}
