package com.kh.dep.personManagement.model.pmDao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

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
	public ArrayList<Working> depMgtdayList(SqlSessionTemplate sqlSession, String day) {
		// TODO Auto-generated method stub
		System.out.println("근태 다오 입장");
		ArrayList<Working> list = (ArrayList) sqlSession.selectList("Working.workingdaySelectList",day);
		
		return list;
	}

}
