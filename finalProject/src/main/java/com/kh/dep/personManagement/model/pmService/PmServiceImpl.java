package com.kh.dep.personManagement.model.pmService;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.personManagement.model.pmDao.PmDao;
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
	public ArrayList<Working> depMgtdayList(String day) {
		// TODO Auto-generated method stub
		System.out.println("근태 서비스 입장");
		ArrayList<Working> list = pd.depMgtdayList(sqlSession,day);
		
		System.out.println(list);
		return list;
	}

	
}
