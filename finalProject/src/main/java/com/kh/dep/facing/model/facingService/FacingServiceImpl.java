package com.kh.dep.facing.model.facingService;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.facingDao.FacingDao;
import com.kh.dep.facing.model.vo.Facing;
import com.kh.dep.member.model.vo.MemberJob;

import oracle.net.aso.f;

@Service
public class FacingServiceImpl implements FacingService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private FacingDao fd;
	@Override
	public ArrayList<Facing> selectFacingList(int userNo) throws FacingSelectListException {
		// TODO Auto-generated method stub
		
		System.out.println("서비스 입장");
		ArrayList<Facing> Facinglist = fd.selectFacingList(sqlSession,userNo);
		
		System.out.println("돌아온 리스트 값 :" + Facinglist);
		
		return Facinglist;
		
	}
	
	

	/*@Override
	public ArrayList<Facing> selectFacingList(int userNo) {
		// TODO Auto-generated method stub
		
		ArrayList<Facing> selectList =  fd.selectFacingList(sqlSession , userNo);
		
		return selectList;
	}*/
	
	
		
}
